package ua.shamray.weatherapiv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.shamray.weatherapiv2.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityByName(String cityName);

}
