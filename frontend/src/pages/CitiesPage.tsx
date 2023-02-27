import '../styles/pages/CitiesPage.css'

import { Layout } from 'antd'
import { useEffect } from 'react';

import IPage from '../interfaces/IPage';
import logging from '../configs/logging';

import HeaderPanel from '../components/panels/HeaderPanel'
import LeftPanel from '../components/panels/LeftPanel'
import CitiesContentPanel from '../components/panels/CitiesContentPanel';
import FooterPanel from '../components/panels/FooterPanel'


const CitiesPage: React.FunctionComponent<IPage> = props => {
    useEffect(() => {
        logging.info(`Loading ${props.name}`);
    }, [props.name])

    return (
        <Layout>
            {/* Left sider Panel */}
            <LeftPanel />

            <Layout id="main-layout">
                {/* Header Panel */}
                <HeaderPanel />

                {/* Cities Content Panel */}
                <CitiesContentPanel />

                {/* Footer Panel */}
                <FooterPanel />
            </Layout>
        </Layout>
    )
}

export default CitiesPage;
