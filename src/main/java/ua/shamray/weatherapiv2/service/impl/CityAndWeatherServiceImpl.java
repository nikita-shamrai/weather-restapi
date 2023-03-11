package ua.shamray.weatherapiv2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.repository.CityRepository;
import ua.shamray.weatherapiv2.service.CityAndWeatherService;
import ua.shamray.weatherapiv2.service.CityService;
import ua.shamray.weatherapiv2.service.WeatherService;
@Service
@RequiredArgsConstructor
public class CityAndWeatherServiceImpl implements CityAndWeatherService {
    private final CityService cityService;
    private final CityRepository cityRepository;
    private final WeatherService weatherService;
    private final CityAndWeatherMapper cityAndWeatherMapper;

    @Override
    @Transactional
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
