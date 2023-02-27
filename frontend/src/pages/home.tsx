import React, { useEffect } from 'react';
import IPage from '../interfaces/IPage';
import logging from '../configs/logging';

const HomePage: React.FunctionComponent<IPage> = props => {
    useEffect(() => {
        logging.info(`Loading ${props.name}`);
    }, [props.name])

    return <p>This is the HOME page!</p>
}

export default HomePage;