package main.java.ua.olejnik.domain;

public class Weather {

    private String city;
    private String description;
    private String temperature;
    private String wind;

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{"
                + "city='"
                + city + '\''
                + ", description='" + description + '\''
                + ", temperature='" + temperature + '\''
                + ", wind='" + wind + '\''
                + '}';
    }
}
