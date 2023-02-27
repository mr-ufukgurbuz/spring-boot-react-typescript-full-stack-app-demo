import '../../styles/panels/LeftPanel.css';

import React, { Component } from 'react';
import { withRouter} from 'react-router-dom';
import { Menu } from 'antd';
import { TeamOutlined, ReadOutlined } from '@ant-design/icons';
import Sider from 'antd/lib/layout/Sider';
import { APP_URL, APP_VERSION } from '../../constants/constants';


interface IState 
{ 
    activeItem: string;
}

class LeftPanel extends Component<any, IState>
{
    constructor(props: any)
    {
        super(props);

        this.state = {
            activeItem: 'authors'
        }
        this.handleMenuItemClick = this.handleMenuItemClick.bind(this);
    }

    handleMenuItemClick = (activeItemName: string) => () => 
    {
        console.log(this.state.activeItem);

        if (activeItemName === "authors")
        {
            this.props.history.push("/authors");
        }
        else if (activeItemName === "books")
        {
            this.props.history.push("/books");
        }
        else // cities
        {
            this.props.history.push("/cities");
        }
    }

    render()
    {
        return (
        <Sider
            style={{
            overflow: 'auto',
            height: '100vh',
            position: 'fixed',
            left: 0,
            }}
        >

            <a href={APP_URL}>
                <div id="company-logo">
                    <img src="demo-app-logo.png" alt="demo-app-logo" width="140" ></img>
                </div>
            </a>

            <Menu id="left-menu" theme="dark" mode="inline" defaultSelectedKeys={['authors']}>
                <Menu.Item key="authors" onClick={this.handleMenuItemClick('authors')} icon={<TeamOutlined />}>AUTHORS</Menu.Item>
                <Menu.Item key="books" onClick={this.handleMenuItemClick('books')} icon={<ReadOutlined />}>BOOKS</Menu.Item>
                <Menu.Item key="cities" onClick={this.handleMenuItemClick('cities')} icon={<ReadOutlined />}>CITIES</Menu.Item>
            </Menu>

            <div id="version">ver. {APP_VERSION}</div>
        </Sider>
        )
    }
}

export default withRouter(LeftPanel);