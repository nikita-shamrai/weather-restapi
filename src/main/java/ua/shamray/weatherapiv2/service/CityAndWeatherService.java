package ua.shamray.weatherapiv2.service;

import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;

@Service
public interface CityAndWeatherService {

    CityAndWeatherDTO getWeatherForCityByName(String cityName);

}
