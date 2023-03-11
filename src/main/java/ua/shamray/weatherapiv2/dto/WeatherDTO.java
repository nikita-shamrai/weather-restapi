package ua.shamray.weatherapiv2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class WeatherDTO {
    @JsonIgnore
    private Long id;
    private String weatherStatus;
    private Double temperature;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime onTime;

}
