import '../styles/pages/BooksPage.css'

import { Layout } from 'antd'
import { useEffect } from 'react';

import IPage from '../interfaces/IPage';
import logging from '../configs/logging';

import HeaderPanel from '../components/panels/HeaderPanel'
import LeftPanel from '../components/panels/LeftPanel'
import BooksContentPanel from '../components/panels/BooksContentPanel';
import FooterPanel from '../components/panels/FooterPanel'


const BooksPage: React.FunctionComponent<IPage> = props => {
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

                {/* Books Content Panel */}
                <BooksContentPanel />

                {/* Footer Panel */}
                <FooterPanel />
            </Layout>
        </Layout>
    )
}

export default BooksPage;
