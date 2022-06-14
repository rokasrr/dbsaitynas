package lt.rokas.db.kirneilio.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceImplTest {

    WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherServiceImpl();
    }


    @Test
    void getCurrentWeatherNotNullTest() {
        Assert.assertTrue(weatherService.getCurrentWeather() != null);
    }

    @Test
    void getCurrentWeatherHasTemperatureTest() {
        Assert.assertTrue(weatherService.getCurrentWeather().getTemperature() != null);
    }

    @Test
    void getCurrentWeatherHasHumidityTest() {
        Assert.assertTrue(weatherService.getCurrentWeather().getHumidity() != null);
    }

    @Test
    void getCurrentWeatherHasCityNameTest() {
        Assert.assertTrue(weatherService.getCurrentWeather().getName() != null);
    }
}