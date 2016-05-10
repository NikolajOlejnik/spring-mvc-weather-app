package main.java.ua.olejnik.util;

import main.java.ua.olejnik.domain.Weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonWeatherParser {

    private String jsonToParsing;
    private final JSONParser parser = new JSONParser();

    public void setJsonToParsing(String jsonToParsing) {
        this.jsonToParsing = jsonToParsing;
    }

    public Weather getWeather() throws ParseException {

        Weather weather = new Weather();
        Object obj = parser.parse(jsonToParsing);

        JSONObject mainJsonObj = (JSONObject) obj;

        JSONObject mainArray = (JSONObject) mainJsonObj.get("main");
        JSONObject windArray = (JSONObject) mainJsonObj.get("wind");
        JSONObject countryObject = (JSONObject) mainJsonObj.get("sys");

        JSONArray weatherArray = (JSONArray) mainJsonObj.get("weather");
        JSONObject descriptionObject = (JSONObject) weatherArray.get(0);

        weather.setCity(getCityDescription(mainJsonObj, countryObject));
        weather.setDescription(String.valueOf(
                descriptionObject.get("description")));
        weather.setTemperature(getTemperatureDescription(mainArray));
        weather.setWind(getWindDescription(windArray));

        return weather;
    }

    private String getCityDescription(JSONObject jsonObject,
                                      JSONObject countryObject) {
        return String.valueOf(jsonObject.get("name"))
                .concat(", ")
                .concat(String.valueOf(countryObject.get("country")));
    }

    private String getTemperatureDescription(JSONObject jsonObject) {
        return String.valueOf(new KelvinToCelsiusConverter(
                (Double) (jsonObject.get("temp"))).getCelsiusString());
    }

    private String getWindDescription(JSONObject jsonObject) {
        String degreesWindString = String.valueOf(jsonObject.get("deg"));
        return DegreesToDirectionConverter.convert(degreesWindString)
                .concat(", ")
                .concat(String.valueOf(jsonObject.get("speed")))
                .concat(" m/s");
    }
}
