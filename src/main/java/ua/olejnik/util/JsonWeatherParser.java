package main.java.ua.olejnik.util;

import main.java.ua.olejnik.domain.Weather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonWeatherParser {

    public Weather getWeather (String weatherJson) throws ParseException {
        Weather weather = new Weather();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(weatherJson);
        JSONObject jsonObj = (JSONObject) obj;
        JSONObject weatherArray = (JSONObject) jsonObj.get("main");
        weather.setTemperature(KelvinToCelsiusConverter.convert((Double) weatherArray.get("temp")));
        return weather;
    }
}
