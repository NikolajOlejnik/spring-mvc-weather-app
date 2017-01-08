package ua.olejnik.domain;

public class Weather {

    private String city;
    private String description;
    private String temperature;
    private String wind;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
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
