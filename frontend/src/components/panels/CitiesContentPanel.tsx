import '../../styles/panels/CitiesContentPanel.css';

import { Component } from 'react';
import { Layout } from 'antd';
import CitiesContent from '../contents/CitiesContent';

class CitiesContentPanel extends Component
{
    render()
    {
        return (
          <Layout className="cities-content-panel-background">
            <CitiesContent/>
          </Layout>
        );
    }
}

export default CitiesContentPanel;