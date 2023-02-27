import BookRequest from "./BookRequest";

interface AuthorRequest 
{
    key: React.Key;
    name: string;
    surname: string;
    books: BookRequest[];
};

export default AuthorRequest;