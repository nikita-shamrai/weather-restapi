package ua.shamray.weatherapiv2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.repository.CityRepository;
import ua.shamray.weatherapiv2.service.CityService;
import ua.shamray.weatherapiv2.service.api.GeoAPIService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final GeoAPIService geoAPIService;
    private final CityAndWeatherMapper cityAndWeatherMapper;

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

    private Optional<City> cityAlreadyExistsInDB(String cityName) {
        return cityRepository.findByName(cityName);
    }

}
