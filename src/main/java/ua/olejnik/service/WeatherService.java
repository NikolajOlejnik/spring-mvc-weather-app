package ua.olejnik.service;

import ua.olejnik.domain.Weather;
import ua.olejnik.util.JsonWeatherParser;

import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherService {

    private final JsonWeatherParser parser = new JsonWeatherParser();
    private final Pattern pattern = Pattern.compile("^*[^0-9/]*$");

    public Weather getWeather(String city) throws IOException, ParseException {
        if (!validate(city)) {
            throw new ParseException(0, city);
        }
        return getWeatherFromJson(getJsonFromServer(city));
    }

    private Boolean validate(String city) {
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    private Weather getWeatherFromJson(String json) throws ParseException {
        parser.setJsonToParsing(json);
        return parser.getWeather();
    }

    private String getJsonFromServer(String city) throws IOException {

        String result = "";

        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&APPID=18941878d8bee31166d6201ef9886fb2");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result += result.concat(inputLine);
        }
        in.close();
        return result;
    }

}
