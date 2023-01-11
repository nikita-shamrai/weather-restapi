package ua.shamray.weatherapiv2.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;
import ua.shamray.weatherapiv2.dto.CityAndWeatherDTO;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    @Mapping(target = "weatherStatus", expression = "java(weatherAPIResponseDTO.getWeather().get(0).getMain())")
    @Mapping(target = "temperature", expression = "java(weatherAPIResponseDTO.getMain().getTemp())")
    @Mapping(target = "id", ignore = true)
    Weather weatherAPIResponseDTOtoWeather(WeatherAPIResponseDTO weatherAPIResponseDTO);
    @Mapping(target = "weatherStatus", source = "weather.weatherStatus")
    @Mapping(target = "temperature", source = "weather.temperature")
    CityAndWeatherDTO updateDTOWithWeather(@MappingTarget CityAndWeatherDTO cityAndWeatherDTO, Weather weather);
    @Mapping(target = "name", source = "city.name")
    @Mapping(target = "lat", source = "city.lat")
    @Mapping(target = "lon", source = "city.lon")
    CityAndWeatherDTO updateDTOWithCity(@MappingTarget CityAndWeatherDTO cityAndWeatherDTO, City city);


}
