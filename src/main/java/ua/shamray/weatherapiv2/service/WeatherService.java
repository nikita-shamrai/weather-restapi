package ua.shamray.weatherapiv2.service;

import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;

@Service
public interface WeatherService {

    Weather getWeatherViaWeatherAPIAndSaveToDB(City city);

}
