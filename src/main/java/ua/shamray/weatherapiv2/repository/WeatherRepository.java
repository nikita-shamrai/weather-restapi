package ua.shamray.weatherapiv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.shamray.weatherapiv2.domain.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
