package ua.shamray.weatherapiv2.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class WeatherDTO {
    private Long id;
    private String weatherStatus;
    private Double temperature;
    private LocalDateTime onTime;

}
