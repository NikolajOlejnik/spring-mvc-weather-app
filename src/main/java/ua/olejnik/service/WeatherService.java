package ua.olejnik.service;

import org.json.simple.parser.ParseException;
import ua.olejnik.domain.Weather;

import java.io.IOException;

/**
 * Created by nick on 1/8/17.
 */
public interface WeatherService {
    Weather getCurrentWeather(String city) throws IOException, ParseException;
}
