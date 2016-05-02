package main.java.ua.olejnik.util;

public class KelvinToCelsiusConverter {

    public static String convert (Double kelvin) {
        String result = String.valueOf (kelvin - 273);
        return result.substring(0, result.indexOf('.'));
    }

}
