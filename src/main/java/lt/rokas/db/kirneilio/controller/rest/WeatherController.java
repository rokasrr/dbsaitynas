package lt.rokas.db.kirneilio.controller.rest;

import lt.rokas.db.kirneilio.dto.WeatherDto;
import lt.rokas.db.kirneilio.service.WeatherService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    public WeatherController() {
    }

    @GetMapping("/weather")
    public WeatherDto getCurrentWeather() {
            return weatherService.getCurrentWeather();
    }

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
