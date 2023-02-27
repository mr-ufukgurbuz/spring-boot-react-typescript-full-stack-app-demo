import axios from 'axios';
import { API_URL, ROUTES } from '../constants/constants';
import CityRequest from '../models/requests/CityRequest';
import CityResponse from '../models/responses/CityResponse';

class CityJPAService 
{
    // SELECT ALL
    async retrieveAllCities():Promise<CityResponse[]>
    {
        let cities: CityResponse[] | PromiseLike<CityResponse[]> = [];

        try 
        {
            const response = await axios.get<CityResponse[]>(API_URL + "/jpa" + ROUTES.CITIES);

            cities = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return cities;
    }

    // SELECT ONE
    async retrieveCity(key: number):Promise<CityResponse>
    {
        let city: CityResponse | PromiseLike<CityResponse> = {key:-1, code:-1, name:'-', latitude:-1, longitude:-1, _class:'-'};

        try 
        {
            const response = await  axios.get<CityResponse>(API_URL + "/jpa" + ROUTES.CITIES + "/" + key)

            city = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return city;
    }

    // CREATE
    async createCity(city:CityRequest):Promise<CityResponse>
    {
        let insertedCity: CityResponse | PromiseLike<CityResponse> = {key:-1, code:-1, name:'-', latitude:-1, longitude:-1, _class:'-'};

        try 
        {
            const response = await  axios.post<CityResponse>(API_URL + "/jpa" + ROUTES.CITIES, city);

            insertedCity = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return insertedCity;
    }

    // UPDATE
    async updateCity(city:CityRequest):Promise<CityResponse>
    {
        let updatedCity: CityResponse | PromiseLike<CityResponse> = {key:-1, code:-1, name:'-', latitude:-1, longitude:-1, _class:'-'};

        try 
        {
            const response = await  axios.put<CityResponse>(API_URL + "/jpa" + ROUTES.CITIES, city);

            updatedCity = response.data;
        } 
        catch (err) 
        {
            console.error(err);
        }

        return updatedCity;
    }

    // DELETE
    async deleteCity(key: number):Promise<CityResponse>
    {
        let deletedCity: CityResponse | PromiseLike<CityResponse> = {key:-1, code:-1, name:'-', latitude:-1, longitude:-1, _class:'-'};

        try 
        {
            const response = await  axios.delete<CityResponse>(API_URL + "/jpa" + ROUTES.CITIES + "/" + key)

            deletedCity = response.data;
        } 
        catch (err) 
        {
            console.error(err);    
        }

        return deletedCity;
    }
}

export default new CityJPAService()