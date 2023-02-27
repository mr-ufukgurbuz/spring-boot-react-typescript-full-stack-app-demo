import axios from 'axios';
import { API_URL, ROUTES } from '../constants/constants';
import AuthorRequest from '../models/requests/AuthorRequest';
import AuthorResponse from '../models/responses/AuthorResponse';

class AuthorJPAService 
{
    // SELECT ALL
    async retrieveAllAuthors():Promise<AuthorResponse[]>
    {
        let authors: AuthorResponse[] | PromiseLike<AuthorResponse[]> = [];

        try 
        {
            const response = await axios.get<AuthorResponse[]>(API_URL + "/jpa" + ROUTES.AUTHORS);

            authors = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return authors;
    }

    // SELECT ONE
    async retrieveAuthor(key: number):Promise<AuthorResponse>
    {
        let author: AuthorResponse | PromiseLike<AuthorResponse> = {key:-1, name:'-', surname:'-', books:[]};

        try 
        {
            const response = await  axios.get<AuthorResponse>(API_URL + "/jpa" + ROUTES.AUTHORS + "/" + key)

            author = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return author;
    }

    // CREATE
    async createAuthor(author:AuthorRequest):Promise<AuthorResponse>
    {
        let insertedAuthor: AuthorResponse | PromiseLike<AuthorResponse> = {key:-1, name:'-', surname:'-', books:[]};

        try 
        {
            const response = await  axios.post<AuthorResponse>(API_URL + "/jpa" + ROUTES.AUTHORS, author);

            insertedAuthor = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return insertedAuthor;
    }

    // UPDATE
    async updateAuthor(author:AuthorRequest):Promise<AuthorResponse>
    {
        let updatedAuthor: AuthorResponse | PromiseLike<AuthorResponse> = {key:-1, name:'-', surname:'-', books:[]};

        try 
        {
            const response = await  axios.put<AuthorResponse>(API_URL + "/jpa" + ROUTES.AUTHORS, author);

            updatedAuthor = response.data;
        } 
        catch (err) 
        {
            console.error(err);
        }

        return updatedAuthor;
    }

    // DELETE
    async deleteAuthor(key: number):Promise<AuthorResponse>
    {
        let deletedAuthor: AuthorResponse | PromiseLike<AuthorResponse> = {key:-1, name:'-', surname:'-', books:[]};

        try 
        {
            const response = await  axios.delete<AuthorResponse>(API_URL + "/jpa" + ROUTES.AUTHORS + "/" + key)

            deletedAuthor = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return deletedAuthor;
    }
}

export default new AuthorJPAService()