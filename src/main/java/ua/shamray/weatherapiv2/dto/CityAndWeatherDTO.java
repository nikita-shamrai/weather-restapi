package ua.shamray.weatherapiv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;

@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(alphabetic = true)
public class CityAndWeatherDTO {

    private String name;
    private Double lat;
    private Double lon;
    private String weatherStatus;
    private Double temperature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void setWeatherStatus(String weatherStatus) {
        this.weatherStatus = weatherStatus;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void mapThisByCityAndWeather(City city, Weather weather){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(city, this);

        modelMapper.map(weather, this);

        //тут нулл
    }

}
