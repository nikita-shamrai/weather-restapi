package ua.shamray.weatherapiv2.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.dto.CityDTO;
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
    private ModelMapper modelMapper;

    @Override
    public City getCityByName(String cityName) {
        Optional<City> city = cityAlreadyExistsInDB(cityName);
        return city.orElse(convertDTOtoCity(geoAPIService.createValidCity(cityName)));
    }


    //@Nullable или NotNull//ИЗУЧИТЬ!!!
    private Optional<City> cityAlreadyExistsInDB(String cityName) {
        return Optional.empty();
    }
    @Override
    public City convertDTOtoCity(CityDTO cityDTO) {
        City city = new City();
        modelMapper.map(cityDTO, city);
        return city;
    }

}
