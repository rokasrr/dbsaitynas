package lt.rokas.db.kirneilio.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lt.rokas.db.kirneilio.dto.WeatherDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherDto getCurrentWeather() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/weather?q=Moletai&lat=0&lon=0&id=2172797&lang=null&units=metric")
                .get()
                .addHeader("X-RapidAPI-Key", "e3cd1dbd07mshe80b076c581e35dp19f12fjsnba0ef652563b")
                .addHeader("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com")
                .build();

        Response response = null;

        WeatherDto dto = new WeatherDto();
        JSONObject Jobject = null;
        try {
            response = client.newCall(request).execute();
            String jsonData = response.body().string();
            Jobject = new JSONObject(jsonData);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        try {
            dto.setHumidity(Jobject.getJSONObject("main").getString("humidity"));
            dto.setTemperature(Jobject.getJSONObject("main").getString("temp"));
            dto.setName(Jobject.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
