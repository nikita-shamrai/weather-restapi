package ua.shamray.weatherapiv2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.repository.CityRepository;
import ua.shamray.weatherapiv2.service.CityService;
import ua.shamray.weatherapiv2.service.api.GeoAPIService;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private GeoAPIService geoAPIService;
    @Autowired
    private CityAndWeatherMapper cityAndWeatherMapper;


    //Нужен ли тут опшинал или можно просто проверять на НУЛЛ?
    @Override
    public City getCityByName(String cityName) {
        Optional<City> cityFromDB = cityAlreadyExistsInDB(cityName);
        if (cityFromDB.isEmpty()){
            City city = cityAndWeatherMapper.convertCityDTOtoCity(geoAPIService.createValidCity(cityName));
            cityRepository.save(city);
            return city;
        }
        return cityFromDB.get();
    }
    // @Nullable ?????
    private Optional<City> cityAlreadyExistsInDB(String cityName) {
        return Optional.ofNullable(cityRepository.findCityByName(cityName));
    }

}
