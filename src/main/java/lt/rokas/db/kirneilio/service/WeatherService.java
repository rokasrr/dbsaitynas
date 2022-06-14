package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.dto.WeatherDto;
import org.json.JSONException;

import java.io.IOException;

public interface WeatherService {
    WeatherDto getCurrentWeather();
}
