package lt.rokas.db.kirneilio.dto;

/**
 * Weather Dto classss
 */
public class WeatherDto {
    private String temperature;
    private String humidity;
    private String name;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
