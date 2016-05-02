package main.java.ua.olejnik.util;

import main.java.ua.olejnik.domain.Weather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonWeatherParser {

    private final static JSONParser parser = new JSONParser();

    public Weather getWeather (String weatherJson) throws ParseException {

        Weather weather = new Weather();

        Object obj = parser.parse(weatherJson);

        JSONObject jsonObj = (JSONObject) obj;

        JSONObject mainArray = (JSONObject) jsonObj.get("main");
        JSONObject countryObject = (JSONObject) jsonObj.get("sys");

        JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
        JSONObject descriptionObject = (JSONObject) weatherArray.get(0);

        weather.setCity(String.valueOf(jsonObj.get("name")).concat(", ").concat(String.valueOf(countryObject.get("country"))));
        weather.setDescription(String.valueOf(descriptionObject.get("description")));
        weather.setTemperature(KelvinToCelsiusConverter.convert((Double) mainArray.get("temp")));

        return weather;
    }

}
