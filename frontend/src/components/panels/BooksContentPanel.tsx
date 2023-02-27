import '../../styles/panels/BooksContentPanel.css';


import { Component } from 'react';
import { Layout } from 'antd';
import BooksContent from '../contents/BooksContent';

class BooksContentPanel extends Component
{
    render()
    {
        return (
          <Layout className="books-content-panel-background">
            <BooksContent/>
          </Layout>
        );
    }
}

export default BooksContentPanel;