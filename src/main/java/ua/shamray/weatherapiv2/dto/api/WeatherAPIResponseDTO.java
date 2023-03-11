package ua.shamray.weatherapiv2.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class WeatherAPIResponseDTO {
    private Coord coord;
    private ArrayList<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    @Getter
    @Setter
    public static class Clouds {
        private int all;

    }

    @Getter
    @Setter
    public static class Coord {
        private double lon;
        private double lat;

    }

    @Getter
    @Setter
    public static class Main {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        @JsonProperty("sea_level")
        private int seaLevel;
        @JsonProperty("grnd_level")
        private int grndLevel;

    }

    @Getter
    @Setter
    public static class Rain {
        @JsonProperty("1h")
        private double _1h;

    }

    @Getter
    @Setter
    public static class Sys {
        private int type;
        private int id;
        private String country;
        private int sunrise;
        private int sunset;

    }

    @Getter
    @Setter
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

    }
    @Getter
    @Setter
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;

    }

}




