package ua.shamray.weatherapiv2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.mapper.WeatherMapper;
import ua.shamray.weatherapiv2.service.CityAndWeatherService;
import ua.shamray.weatherapiv2.service.CityService;
import ua.shamray.weatherapiv2.service.WeatherService;
@Service
public class CityAndWeatherServiceImpl implements CityAndWeatherService {
    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    public CityAndWeatherDTO getWeatherForCityByName(String cityName) {
        City city = cityService.getCityByName(cityName);
        Weather weather = weatherService.getWeatherViaWeatherAPI(city);


        CityAndWeatherDTO cityAndWeatherDTO = new CityAndWeatherDTO();
       // cityAndWeatherDTO.mapThisByCityAndWeather(city, weather);
        weatherMapper.updateDTOWithCity(cityAndWeatherDTO, city);
        weatherMapper.updateDTOWithWeather(cityAndWeatherDTO, weather);

        return cityAndWeatherDTO;
    }
}
