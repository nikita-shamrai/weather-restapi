package ua.shamray.weatherapiv2.service.api;

import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;


@Service
public interface WeatherAPIService {

    WeatherAPIResponseDTO fetchWeatherNowByCoordinates(Double lat, Double lon);


}
