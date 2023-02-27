import AuthorRequest from "./AuthorRequest";

interface BookRequest 
{
    key: React.Key;
    description: string;
    author: AuthorRequest;
};

export default BookRequest;