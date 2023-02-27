import axios from 'axios';
import { API_URL, ROUTES } from '../constants/constants';
import BookRequest from '../models/requests/BookRequest';
import BookResponse from '../models/responses/BookResponse';

class BookService 
{
    // SELECT ALL
    async retrieveAllBooks():Promise<BookResponse[]>
    {
        let books: BookResponse[] | PromiseLike<BookResponse[]> = [];

        try 
        {
            const response = await axios.get<BookResponse[]>(API_URL + ROUTES.BOOKS);

            books = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return books;
    }

    // SELECT ONE
    async retrieveBook(key: number):Promise<BookResponse>
    {
        let book: BookResponse | PromiseLike<BookResponse> = {key:-1, name:'-', description:'-', author:{key:-1, name:'-', surname:'-', books:[]}};

        try 
        {
            const response = await  axios.get<BookResponse>(API_URL + ROUTES.BOOKS + "/" + key)

            book = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return book;
    }

    // CREATE
    async createBook(book:BookRequest):Promise<BookResponse>
    {
        let insertedBook: BookResponse | PromiseLike<BookResponse> = {key:-1, name:'-', description:'-', author:{key:-1, name:'-', surname:'-', books:[]}};

        try 
        {
            const response = await  axios.post<BookResponse>(API_URL + ROUTES.BOOKS, book);

            insertedBook = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return insertedBook;
    }

    // UPDATE
    async updateBook(book:BookRequest):Promise<BookResponse>
    {
        let updatedBook: BookResponse | PromiseLike<BookResponse> = {key:-1, name:'-', description:'-', author:{key:-1, name:'-', surname:'-', books:[]}};

        try 
        {
            const response = await  axios.put<BookResponse>(API_URL + ROUTES.BOOKS, book);

            updatedBook = response.data;
        } 
        catch (err) 
        {
            console.error(err);
        }

        return updatedBook;
    }

    // DELETE
    async deleteBook(key: number):Promise<BookResponse>
    {
        let deletedBook: BookResponse | PromiseLike<BookResponse> = {key:-1, name:'-', description:'-', author:{key:-1, name:'-', surname:'-', books:[]}};

        try 
        {
            const response = await  axios.delete<BookResponse>(API_URL + ROUTES.BOOKS + "/" + key)

            deletedBook = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return deletedBook;
    }
}

export default new BookService()