package main.java.ua.olejnik.service;

import main.java.ua.olejnik.domain.Weather;
import main.java.ua.olejnik.util.JsonWeatherParser;

import org.json.simple.parser.ParseException;

public class WeatherService {

    private static final JsonWeatherParser parser = new JsonWeatherParser();

    public Weather getWeatherFromJson(String json) throws ParseException {
        return parser.getWeather(json);
    }
}
