import '../../styles/contents/AuthorsContent.css';

import { Content } from 'antd/lib/layout/layout';
import React, { Component } from 'react';
import { Table, Input, Button, Popconfirm, Form, Typography, InputNumber } from 'antd';
import { FormInstance } from 'antd/lib/form';
import AuthorResponse from '../../models/responses/AuthorResponse';
import AuthorService from '../../services/AuthorService';

const EditableContext = React.createContext<FormInstance<any> | null>(null);

interface EditableRowProps {
  index: number;
}

const EditableRow: React.FC<EditableRowProps> = ({ index, ...props }) => {
  const [form] = Form.useForm();
  return (
    <Form form={form} component={false}>
      <EditableContext.Provider value={form}>
        <tr {...props} />
      </EditableContext.Provider>
    </Form>
  );
};

interface EditableCellProps {
  title: React.ReactNode;
  editable: boolean;
  children: React.ReactNode;
  dataIndex: keyof AuthorResponse;
  inputType: 'number' | 'text';
  record: AuthorResponse;
  index: number;
}

const EditableCell: React.FC<EditableCellProps> = ({
  title,
  editable,
  children,
  dataIndex,
  inputType,
  record,
  index,
  ...restProps
}) => {
  const inputNode = inputType === 'number' ? <InputNumber /> : <Input />;

  return (
    <td {...restProps}>
      {editable ? (
        <Form.Item
          name={dataIndex}
          style={{ margin: 0 }}
          rules={[
            {
              required: true,
              message: `Please Input ${title}!`,
            },
          ]}
        >
          {inputNode}
        </Form.Item>
      ) : (
        children
      )}
    </td>
  );
};

type EditableTableProps = Parameters<typeof Table>[0];

interface EditableTableState {
  dataSource: AuthorResponse[];
  count: number;
  editableKey: React.Key;
}

type ColumnTypes = Exclude<EditableTableProps['columns'], undefined>;

class EditableTable extends React.Component<EditableTableProps, EditableTableState> {

  constructor(props: EditableTableProps) {
    super(props);

    this.state = {
      dataSource: [
        /*{
          key: 0,
          name: 'name-0',
          surname: 'surname-0',
          books: [],
        },
        {
          key: 1,
          name: 'name-1',
          surname: 'surname-1',
          books: [],
        },*/
      ],
      count: 0,
      editableKey: '',
    };

    this.fillAuthorsTable = this.fillAuthorsTable.bind(this);
    
    this.fillAuthorsTable();
  }

  isEditable = (record: AuthorResponse) => record.key === this.state.editableKey;

  columns = [
    {
      title: '#AuthorId',
      dataIndex: 'key',
      width: '5%',
      editable: false,
    },
    {
      title: 'Name',
      dataIndex: 'name',
      width: '15%',
      editable: true,
    },
    {
      title: 'Surname',
      dataIndex: 'surname',
      width: '15%',
      editable: true,
    },
    {
      title: 'Books',
      dataIndex: 'books',
      width: '45%',
      editable: true,
    },
    {
      title: 'Edit',
      dataIndex: 'edit',
      width: '5%',
      render: (_: any, record: AuthorResponse) => {
        const editable = this.isEditable(record);
        return editable ? (
          <span>
            <a href="" onClick={() => this.handleSave(record)} style={{ marginRight: 8 }}>
              Save
            </a>
            <Popconfirm title="Sure to cancel?" onConfirm={this.handleCancel}>
              <a href="">Cancel</a>
            </Popconfirm>
          </span>
        ) : (
          <Typography.Link disabled={this.state.editableKey !== ''} onClick={() => this.handleEdit(record)}>
            Edit
          </Typography.Link>
        );
      },
    },
    {
      title: 'Delete',
      dataIndex: 'delete',
      width: '5%',
      render: (_: any, record: {key: React.Key}) => 
      this.state.dataSource.length >= 1 ? (
        <Popconfirm title="Sure to delete?" onConfirm={() => this.handleDelete(record.key)}>
          <a>Delete</a>
        </Popconfirm>
      ) : null,
    },
  ];

  fillAuthorsTable = () => {
    let authors = AuthorService.retrieveAllAuthors();

    authors.then((authorItems) => 
    {
        this.setState({dataSource: authorItems, count: authorItems.length});
    });
  }

  //form = useContext(EditableContext)!;
  //form = Form.useForm();

  handleEdit = (record: Partial<AuthorResponse> & { key: React.Key }) => {
    console.log("edit girdim");
    /*this.form.setFieldsValue({ name: '', surname: '', books: '', ...record });
    this.setState({ editableKey: record.key });*/
  };

  handleCancel = () => {
    console.log("cancel girdim");
  };

  handleSave = async (row: AuthorResponse) => {
    console.log('save');
    try {
      //const row:AuthorResponse = await this.form.validateFields();

      const newData = [...this.state.dataSource];
      const index = newData.findIndex(item => row.key === item.key);
      const item = newData[index];
      newData.splice(index, 1, {
        ...item,
        ...row,
      });
      this.setState({ dataSource: newData });
    } 
    catch (errInfo) {
      console.log('Validate Failed:', errInfo);
    }
  };

  handleDelete = (key: React.Key) => {
    // gets tableData from React.Table
    const dataSource = [...this.state.dataSource];
    // deletes related row
    this.setState({ dataSource: dataSource.filter(item => item.key !== key) });
  };

  handleAdd = () => {
    const { count, dataSource } = this.state;
    const newData: AuthorResponse = {
      key: count,
      name: `name-${count}`,
      surname: `surname-${count}`,
      books: []
    };
    this.setState({
      dataSource: [...dataSource, newData],
      count: count + 1,
    });
  };

  render() {
    const { dataSource } = this.state;
    const components = {
      body: {
        row: EditableRow,
        cell: EditableCell,
      },
    };
    const columns = this.columns.map(col => {
      if (!col.editable) {
        return col;
      }
      return {
        ...col,
        onCell: (record: AuthorResponse) => ({
          record,
          inputType: col.dataIndex === 'key' ? 'number' : 'text',
          //editable: col.editable,
          dataIndex: col.dataIndex,
          title: col.title,
          editable: this.isEditable(record),
        }),
      };
    });
    return (
      <div>
        <Button onClick={this.handleAdd} type="primary" style={{ marginBottom: 16, marginLeft:1450, }}>
          Add new Author
        </Button>
        <Table
          components={components}
          rowClassName={() => 'editable-row'}
          bordered
          dataSource={dataSource}
          columns={columns as ColumnTypes}
          pagination={{
            onChange: this.handleCancel,
          }}
        />
      </div>
    );
  }
}

class AuthorsContent extends Component
{
    render()
    {
        return (
          <Content className="author-panel">
            <div className="author-ghost-wrapper">
              <p>AUTHORS</p>
            </div>
            <EditableTable />
          </Content>
        );
    }
}

export default AuthorsContent;