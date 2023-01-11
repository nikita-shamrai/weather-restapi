package ua.shamray.weatherapiv2.service;

import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;

@Service
public interface WeatherService {

    Weather getWeatherViaWeatherAPI(City city);

}
