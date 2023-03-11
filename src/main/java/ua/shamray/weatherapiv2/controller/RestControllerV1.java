package ua.shamray.weatherapiv2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.CityDTO;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.service.CityAndWeatherService;
import ua.shamray.weatherapiv2.service.CityService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestControllerV1 {
    private final CityAndWeatherService cityAndWeatherService;
    private final CityService cityService;
    private final CityAndWeatherMapper cityAndWeatherMapper;

    @GetMapping("/{city}")
    public ResponseEntity<CityAndWeatherDTO> getWeatherByCityName(@PathVariable(name = "city") String cityName){
        CityAndWeatherDTO cityAndWeatherDTO = cityAndWeatherService.getWeatherForCityByName(cityName);
        return new ResponseEntity<>(cityAndWeatherDTO, HttpStatus.CREATED);
    }

    @GetMapping("/statistic/{city}")
    public ResponseEntity<CityDTO> getWeatherStatisticsByCityName(@PathVariable(name = "city") String cityName){
        CityDTO cityDTO = cityAndWeatherMapper.convertCityToCityDTO(cityService.getCityByName(cityName));
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

}
