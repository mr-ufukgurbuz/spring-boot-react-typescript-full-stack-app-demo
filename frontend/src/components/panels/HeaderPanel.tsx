import '../../styles/panels/HeaderPanel.css';

import { Component } from 'react';
import { Menu, Dropdown, message } from 'antd';
import { UserOutlined, IdcardOutlined, LogoutOutlined } from '@ant-design/icons';
import { Header } from 'antd/lib/layout/layout';

// Logout event
function handleUserMenuClick(e: any) {
    message.info('Click on user menu item.');
    console.log('click', e);
  }
  
  // User event
  function handleUserClick(e: any) {
    message.info('Click on user item.');
    console.log('click', e);
  }
  
  // Logout menu
  const menu = (
    <Menu onClick={handleUserMenuClick}>
      <Menu.Item key="account" icon={<IdcardOutlined />}>
        Account
      </Menu.Item>
      <Menu.Item key="logout" icon={<LogoutOutlined />}>
        Logout
      </Menu.Item>
    </Menu>
  );

class HeaderPanel extends Component
{
    render()
    {
        return (
        <Header className="header" style={{ padding: 0, position: 'fixed', zIndex: 1, width: '89.5%'}}>
            <div>
              
                <h1 id="application-title"> SpringBoot - React_Typescript Full Stack Application Demo </h1>

                <Dropdown.Button className="userDropdownButton" onClick={handleUserClick} overlay={menu} placement="bottomCenter" icon={<UserOutlined />}>
                  <b>User</b>
                </Dropdown.Button>
            </div>
        </Header>
        );
    }
}

export default HeaderPanel;