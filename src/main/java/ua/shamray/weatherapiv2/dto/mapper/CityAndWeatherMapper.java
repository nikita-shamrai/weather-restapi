package ua.shamray.weatherapiv2.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.CityDTO;
import ua.shamray.weatherapiv2.dto.WeatherDTO;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;

@Mapper(componentModel = "spring")
public interface CityAndWeatherMapper {
    @Mapping(target = "weatherStatus", expression = "java(weatherAPIResponseDTO.getWeather().get(0).getMain())")
    @Mapping(target = "temperature", expression = "java(weatherAPIResponseDTO.getMain().getTemp())")
    @Mapping(target = "id", ignore = true)
    Weather weatherAPIResponseDTOtoWeather(WeatherAPIResponseDTO weatherAPIResponseDTO);

    @Mapping(target = "weatherStatus", source = "weather.weatherStatus")
    @Mapping(target = "temperature", source = "weather.temperature")
    void updateCityAndWeatherDTOWithWeather(@MappingTarget CityAndWeatherDTO cityAndWeatherDTO, Weather weather);

    @Mapping(target = "name", source = "city.name")
    @Mapping(target = "lat", source = "city.lat")
    @Mapping(target = "lon", source = "city.lon")
    void updateCityAndWeatherDTOWithCity(@MappingTarget CityAndWeatherDTO cityAndWeatherDTO, City city);
    WeatherDTO convertWeatherToWeatherDTO(Weather weather);

    City convertCityDTOtoCity(CityDTO cityDTO);

    @Mapping(target = "weatherDTOList", expression = "java(city.getWeatherList().stream().map(this::convertWeatherToWeatherDTO).toList())")
    CityDTO convertCityToCityDTO(City city);

}
