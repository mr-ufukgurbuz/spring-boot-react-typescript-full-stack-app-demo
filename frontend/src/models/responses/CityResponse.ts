import React from "react";

interface CityResponse
{
    key: React.Key;
    code: number;
    name: string;
    latitude: number;
    longitude: number;
    _class: string;
};

export default CityResponse;