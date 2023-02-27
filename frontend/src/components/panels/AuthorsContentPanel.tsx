import '../../styles/panels/AuthorsContentPanel.css';

import { Component } from 'react';
import { Layout } from 'antd';
import AuthorsContent from '../contents/AuthorsContent';

class AuthorsContentPanel extends Component
{
    render()
    {
        return (
          <Layout className="authors-content-panel-background">
            <AuthorsContent/>
          </Layout>
        );
    }
}

export default AuthorsContentPanel;