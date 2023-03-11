package ua.shamray.weatherapiv2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityDTO {
    @JsonIgnore
    Long id;
    String name;
    Double lat;
    Double lon;
    List<WeatherDTO> weatherDTOList;

}
