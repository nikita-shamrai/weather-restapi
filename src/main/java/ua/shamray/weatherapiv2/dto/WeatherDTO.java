package ua.shamray.weatherapiv2.dto;

import java.time.LocalDateTime;

public class WeatherDTO {
    private Long id;
    private String weatherStatus;
    private Double temperature;
    private LocalDateTime onTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public LocalDateTime getOnTime() {
        return onTime;
    }

    public void setOnTime(LocalDateTime onTime) {
        this.onTime = onTime;
    }
}
