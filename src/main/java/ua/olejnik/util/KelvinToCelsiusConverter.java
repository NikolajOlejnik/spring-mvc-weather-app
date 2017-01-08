package ua.olejnik.util;

class KelvinToCelsiusConverter {

    private final Double KELVIN_CELSIUS_DIFFERENCE = 273.0;
    private final Double kelvinDouble;
    private String celsiusString;

    public String getCelsiusString() {
        return celsiusString;
    }

    KelvinToCelsiusConverter(Double kelvin) {
        this.kelvinDouble = kelvin;
        convert();
    }

    private void convert() {
        String result = String.valueOf(
                kelvinDouble - KELVIN_CELSIUS_DIFFERENCE);
        celsiusString = result.substring(0, result.indexOf('.'));
    }
}
