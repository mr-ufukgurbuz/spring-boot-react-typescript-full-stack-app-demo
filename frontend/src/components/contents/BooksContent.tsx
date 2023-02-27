import '../../styles/contents/BooksContent.css';

import { Content } from 'antd/lib/layout/layout';
import React, { Component } from 'react';
import { Table, Input, Button, Popconfirm, Form, Typography, InputNumber } from 'antd';
import { FormInstance } from 'antd/lib/form';
import BookResponse from '../../models/responses/BookResponse';
import BookService from '../../services/BookService';

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
  dataIndex: keyof BookResponse;
  inputType: 'number' | 'text';
  record: BookResponse;
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
  dataSource: BookResponse[];
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
          description: 'description-0',
          author: {key:-1, name:'-', surname:'-', books:[]}
        },
        {
          key: 1,
          name: 'name-1',
          description: 'description-1',
          author: {key:-1, name:'-', surname:'-', books:[]}
        },*/
      ],
      count: 0,
      editableKey: '',
    };

    this.fillBooksTable = this.fillBooksTable.bind(this);
    
    this.fillBooksTable();
  }

  isEditable = (record: BookResponse) => record.key === this.state.editableKey;

  columns = [
    {
      title: '#BookId',
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
      title: 'Description',
      dataIndex: 'description',
      width: '15%',
      editable: true,
    },
    {
      title: 'Author',
      dataIndex: 'author',
      width: '45%',
      editable: true,
    },
    {
      title: 'Edit',
      dataIndex: 'edit',
      width: '5%',
      render: (_: any, record: BookResponse) => {
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

  fillBooksTable = () => {
    let books = BookService.retrieveAllBooks();

    books.then((bookItems) => 
    {
        this.setState({dataSource: bookItems, count: bookItems.length});
    });
  }

  //form = useContext(EditableContext)!;
  //form = Form.useForm();

  handleEdit = (record: Partial<BookResponse> & { key: React.Key }) => {
    console.log("edit girdim");
    /*this.form.setFieldsValue({ name: '', description: '', author: '', ...record });
    this.setState({ editableKey: record.key });*/
  };

  handleCancel = () => {
    console.log("cancel girdim");
  };

  handleSave = async (row: BookResponse) => {
    console.log('save');
    try {
      //const row:BookResponse = await this.form.validateFields();

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
    const newData: BookResponse = {
      key: count,
      name: `name-${count}`,
      description: `description-${count}`,
      author: {key:-1, name:'-', surname:'-', books:[]}
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
        onCell: (record: BookResponse) => ({
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
          Add new Book
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

class BooksContent extends Component
{
    render()
    {
        return (
          <Content className="book-panel">
            <div className="book-ghost-wrapper">
              <p>BOOKS</p>
            </div>
            <EditableTable />
          </Content>
        );
    }
}

export default BooksContent;