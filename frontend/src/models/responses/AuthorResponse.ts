import React from "react";
import BookResponse from "./BookResponse";

interface AuthorResponse
{
    key: React.Key;
    name: string;
    surname: string;
    books: BookResponse[];
};

export default AuthorResponse;