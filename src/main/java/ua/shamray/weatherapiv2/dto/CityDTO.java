package ua.shamray.weatherapiv2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    Long id;
    String name;
    Double lat;
    Double lon;
    List<WeatherDTO> weatherDTOList;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<WeatherDTO> getWeatherDTOList() {
        return weatherDTOList;
    }

    public void setWeatherDTOList(List<WeatherDTO> weatherDTOList) {
        this.weatherDTOList = weatherDTOList;
    }
}
