package ua.shamray.weatherapiv2.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;
import ua.shamray.weatherapiv2.dto.mapper.WeatherMapper;
import ua.shamray.weatherapiv2.repository.WeatherRepository;
import ua.shamray.weatherapiv2.service.api.WeatherAPIService;
import ua.shamray.weatherapiv2.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherAPIService weatherAPIService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WeatherMapper weatherMapper;
    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public Weather getWeatherViaWeatherAPIAndSaveToDB(City city) {
        WeatherAPIResponseDTO weatherAPIResponseDTO = weatherAPIService.fetchWeatherNowByCoordinates(city.getLat(), city.getLon());
        Weather weather = weatherMapper.weatherAPIResponseDTOtoWeather(weatherAPIResponseDTO);
        weather.setCity(city);
        weatherRepository.save(weather);
        return weather;
    }

    /*@Override
    public Weather convertWeatherAPIResponseDTOtoWeather(WeatherAPIResponseDTO weatherAPIResponseDTO) {
        Weather weather = new Weather();
        System.out.println();
        modelMapper.map(weatherAPIResponseDTO, weather);
        System.out.println();
        return weather;
    }*/


}
