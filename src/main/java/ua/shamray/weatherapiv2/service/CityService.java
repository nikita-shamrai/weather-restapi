package ua.shamray.weatherapiv2.service;

import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.dto.CityDTO;


public interface CityService {
   City getCityByName(String cityName);
   City convertDTOtoCity(CityDTO cityDTO);

}
