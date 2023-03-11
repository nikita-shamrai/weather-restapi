package ua.shamray.weatherapiv2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.repository.WeatherRepository;
import ua.shamray.weatherapiv2.service.WeatherService;
import ua.shamray.weatherapiv2.service.api.WeatherAPIService;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherAPIService weatherAPIService;
    private final CityAndWeatherMapper cityAndWeatherMapper;
    private final WeatherRepository weatherRepository;

    @Override
    public Weather getWeatherViaWeatherAPIAndSaveToDB(City city) {
        WeatherAPIResponseDTO weatherAPIResponseDTO = weatherAPIService.fetchWeatherNowByCoordinates(city.getLat(), city.getLon());
        Weather weather = cityAndWeatherMapper.weatherAPIResponseDTOtoWeather(weatherAPIResponseDTO);
        weather.setCity(city);
        weatherRepository.save(weather);
        return weather;
    }

}
