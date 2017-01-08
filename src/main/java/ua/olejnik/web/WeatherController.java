package ua.olejnik.web;

import org.springframework.beans.factory.annotation.Autowired;
import ua.olejnik.domain.Weather;
import ua.olejnik.service.WeatherService;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by nick on 1/8/17.
 */
@Controller
@RequestMapping(value = "/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(params = {"city"}, method = RequestMethod.GET)
    public @ResponseBody Weather currentWeather(@RequestParam(value = "city") String city) throws IOException, ParseException {
        return weatherService.getCurrentWeather(city);
    }
}
