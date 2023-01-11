package ua.shamray.weatherapiv2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ua.shamray.weatherapiv2.domain.City;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {
    Long id;
    @JsonProperty("mpaa_rating")
    String weatherStatus;
    Double temperature;
    City city;

}
