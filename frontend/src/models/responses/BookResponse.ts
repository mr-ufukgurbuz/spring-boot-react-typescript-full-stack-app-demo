import AuthorResponse from "./AuthorResponse";

interface BookResponse
{
    key: React.Key;
    name: string;
    description: string;
    author: AuthorResponse;
};

export default BookResponse;