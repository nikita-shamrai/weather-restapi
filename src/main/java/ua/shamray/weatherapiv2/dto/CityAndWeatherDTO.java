package ua.shamray.weatherapiv2.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import ua.shamray.weatherapiv2.domain.City;
import ua.shamray.weatherapiv2.domain.Weather;

@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(alphabetic = true)
@Getter
@Setter
public class CityAndWeatherDTO {

    private String name;
    private Double lat;
    private Double lon;
    private String weatherStatus;
    private Double temperature;


}
