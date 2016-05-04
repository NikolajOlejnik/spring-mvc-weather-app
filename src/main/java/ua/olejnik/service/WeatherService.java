package main.java.ua.olejnik.service;

import main.java.ua.olejnik.domain.Weather;
import main.java.ua.olejnik.util.JsonWeatherParser;

import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherService {

    private static final JsonWeatherParser parser = new JsonWeatherParser();

    public Weather getWeatherFromJson (String json) throws ParseException {
        return parser.getWeather(json);
    }

    public Weather getWeather (String city) throws IOException, ParseException {
        String result="";
        URL url = new URL ("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=18941878d8bee31166d6201ef9886fb2");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            result += result.concat(inputLine);
        in.close();
        return getWeatherFromJson(result);
    }

    
}
