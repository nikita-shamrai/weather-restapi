package ua.shamray.weatherapiv2.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String weatherStatus;
    private Double temperature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @CreationTimestamp
    @Column(name = "on_time")
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getOnTime() {
        return onTime;
    }

    public void setOnTime(LocalDateTime onTime) {
        this.onTime = onTime;
    }
}
