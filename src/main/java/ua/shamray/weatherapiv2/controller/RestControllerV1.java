package ua.shamray.weatherapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.CityDTO;
import ua.shamray.weatherapiv2.dto.mapper.CityAndWeatherMapper;
import ua.shamray.weatherapiv2.service.CityAndWeatherService;
import ua.shamray.weatherapiv2.service.CityService;

@RestController
@RequestMapping("/api")
public class RestControllerV1 {

    @Autowired
    private CityAndWeatherService cityAndWeatherService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CityAndWeatherMapper cityAndWeatherMapper;

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
