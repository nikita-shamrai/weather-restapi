package ua.shamray.weatherapiv2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.repository.CityRepository;
import ua.shamray.weatherapiv2.service.CityAndWeatherService;
import ua.shamray.weatherapiv2.service.CityService;
import ua.shamray.weatherapiv2.service.WeatherService;
@Service
public class CityAndWeatherServiceImpl implements CityAndWeatherService {
    @Autowired
    private CityService cityService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CityAndWeatherMapper cityAndWeatherMapper;

    @Override
    public CityAndWeatherDTO getWeatherForCityByName(String cityName) {
        City city = cityService.getCityByName(cityName);
        Weather weather = weatherService.getWeatherViaWeatherAPIAndSaveToDB(city);
        updateWeatherListInCity(city, weather);
        CityAndWeatherDTO cityAndWeatherDTO = new CityAndWeatherDTO();
        cityAndWeatherMapper.updateCityAndWeatherDTOWithCity(cityAndWeatherDTO, city);
        cityAndWeatherMapper.updateCityAndWeatherDTOWithWeather(cityAndWeatherDTO, weather);
        return cityAndWeatherDTO;
    }

    private void updateWeatherListInCity(City city, Weather weather){
        city.getWeatherList().add(weather);
        cityRepository.save(city);
    }


}
