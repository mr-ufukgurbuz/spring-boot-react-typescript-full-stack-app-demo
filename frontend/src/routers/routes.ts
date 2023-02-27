import IRoute from '../interfaces/IRoute';
import { ROUTES } from '../constants/constants';
import AboutPage from '../pages/about';
import HomePage from '../pages/home';
import AuthorsPage from '../pages/AuthorsPage';
import BooksPage from '../pages/BooksPage';
import CitiesPage from '../pages/CitiesPage';

const routes: IRoute[] = [
    {
        path: ROUTES.HOME,
        name: 'Home Page',
        component: HomePage,
        exact: true
    },
    {
        path: ROUTES.ABOUT,
        name: 'About Page',
        component: AboutPage,
        exact: true
    },
    {
        path: ROUTES.ABOUT + ':number',
        name: 'About Page',
        component: AboutPage,
        exact: true
    },
    {
        path: ROUTES.AUTHORS,
        name: 'Authors Page',
        component: AuthorsPage,
        exact: true
    },
    {
        path: ROUTES.BOOKS,
        name: 'Books Page',
        component: BooksPage,
        exact: true
    },
    {
        path: ROUTES.CITIES,
        name: 'Cities Page',
        component: CitiesPage,
        exact: true
    },
]

export default routes;
