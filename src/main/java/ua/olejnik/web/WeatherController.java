package ua.olejnik.web;

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
    private final WeatherService weatherService = new WeatherService();

    @RequestMapping(params = {"city"}, method = RequestMethod.GET)
    public @ResponseBody Weather weather(@RequestParam(value = "city") String city) throws IOException, ParseException {
        return weatherService.getWeather(city);
    }
}
