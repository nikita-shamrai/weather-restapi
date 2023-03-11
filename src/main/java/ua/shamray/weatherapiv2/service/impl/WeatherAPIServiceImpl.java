package ua.shamray.weatherapiv2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import ua.shamray.weatherapiv2.dto.api.WeatherAPIResponseDTO;
import ua.shamray.weatherapiv2.service.api.WeatherAPIService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
@RequiredArgsConstructor
public class WeatherAPIServiceImpl implements WeatherAPIService {

    private final ObjectMapper objectMapper;
    private @Value("${openweathermap.API.KEY}") String API_KEY;
    private @Value("${openweathermap.API.WEATHER.URI}") String API_URI;

    @Override
    public WeatherAPIResponseDTO fetchWeatherNowByCoordinates(Double lat, Double lon) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse;
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(weatherURIBuilder(lat, lon))
                    .timeout(Duration.of(10, SECONDS))
                    .build();
            httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(httpResponse.body(), WeatherAPIResponseDTO.class);
        } catch (InterruptedException | URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private URI weatherURIBuilder(Double lat, Double lon) throws URISyntaxException {
        return UriComponentsBuilder.fromHttpUrl(API_URI)
                .replaceQueryParam("lat", lat)
                .replaceQueryParam("lon", lon)
                .replaceQueryParam("appid", API_KEY)
                .build()
                .toUri();
    }

}
