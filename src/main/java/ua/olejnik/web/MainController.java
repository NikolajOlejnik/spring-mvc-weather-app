package main.java.ua.olejnik.web;

import main.java.ua.olejnik.domain.Weather;
import main.java.ua.olejnik.service.WeatherService;

import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private final WeatherService weatherService = new WeatherService();

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "/weather/{city}", method = RequestMethod.POST)
    public @ResponseBody Weather weather(
            @PathVariable(value = "city") String city) throws IOException, ParseException {
        return weatherService.getWeather(city);
    }
}
