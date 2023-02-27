import '../../styles/panels/FooterPanel.css';

import { Component } from 'react';
import { Layout } from 'antd';
import { Footer } from 'antd/lib/layout/layout';

class FooterPanel extends Component
{
    render()
    {
        return (
        <Layout className="footer-panel-background">
            <Footer className="footer-panel"><b>BABA A.S ©2023 - Created by ufukgurbuz</b></Footer>
        </Layout>
        );
    }
}

export default FooterPanel;