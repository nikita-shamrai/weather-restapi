package ua.shamray.weatherapiv2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import ua.shamray.weatherapiv2.dto.CityDTO;
import ua.shamray.weatherapiv2.service.api.GeoAPIService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class GeoAPIServiceImpl implements GeoAPIService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;
    private @Value("${openweathermap.API.KEY}") String API_KEY;
    private @Value("${openweathermap.API.GEO.URI}") String API_URI;

    @Override
    public CityDTO createValidCity(String cityName) throws NoSuchElementException{
      /*  try {
            WebClient.create()
                    .get()
                    .uri(coordinatesAPIURIBuilder(cityName))
                    .retrieve()
                    .bodyToFlux(CityDTO.class)



        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
*/
        HttpClient client = HttpClient.newHttpClient();
        CityDTO cityDTO;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(coordinatesAPIURIBuilder(cityName))
                    .timeout(Duration.of(10, SECONDS))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.body().isEmpty()){
                throw new NoSuchElementException("City not found");
            }
            CityDTO[] cityDTOS = objectMapper.readValue(response.body(), CityDTO[].class);
            Stream<CityDTO> stream = Arrays.stream(cityDTOS);
            Optional<CityDTO> streamFirst = stream.findFirst();
            cityDTO = streamFirst.orElseThrow(NoSuchElementException::new);
        } catch (URISyntaxException e) {
            throw new RuntimeException("URI INVALID");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return cityDTO;
    }


    private URI coordinatesAPIURIBuilder(String cityName) throws URISyntaxException {
        return UriComponentsBuilder.fromHttpUrl(API_URI)
                .replaceQueryParam("q", cityName)
                .replaceQueryParam("limit", "1")
                .replaceQueryParam("appid", API_KEY)
                .build()
                .toUri();
    }


}
