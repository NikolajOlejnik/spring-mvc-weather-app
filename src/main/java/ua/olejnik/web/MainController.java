package main.java.ua.olejnik.web;

import main.java.ua.olejnik.domain.Weather;
import main.java.ua.olejnik.service.WeatherService;

import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private static final WeatherService weatherService = new WeatherService();

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage () {
        return "index";
    }

    @RequestMapping(value = "/getWeather" , method = RequestMethod.POST)
    public @ResponseBody Weather getWeather (@RequestBody String json) throws ParseException {
        return weatherService.getWeatherFromJson(json);
    }

}
