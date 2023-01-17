package ua.shamray.weatherapiv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.service.CityAndWeatherService;

@RestController
@RequestMapping("/api")
public class RestControllerV1 {

    @Autowired
    private CityAndWeatherService cityAndWeatherService;

    @GetMapping("/{city}")
    public ResponseEntity<CityAndWeatherDTO> getWeatherByCityName(@PathVariable(name = "city") String cityName){
        CityAndWeatherDTO cityAndWeatherDTO = cityAndWeatherService.getWeatherForCityByName(cityName);
        return new ResponseEntity<>(cityAndWeatherDTO, HttpStatus.CREATED);
    }

}
