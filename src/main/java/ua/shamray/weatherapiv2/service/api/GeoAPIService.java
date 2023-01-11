package ua.shamray.weatherapiv2.service.api;

import org.springframework.stereotype.Service;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.dto.CityDTO;


@Service
public interface GeoAPIService {

    CityDTO createValidCity(String cityName);


}
