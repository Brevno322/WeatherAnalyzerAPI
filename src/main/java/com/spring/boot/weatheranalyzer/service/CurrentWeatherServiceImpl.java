package com.spring.boot.weatheranalyzer.service;

import com.spring.boot.weatheranalyzer.dao.CurrentWeatherRepository;
import com.spring.boot.weatheranalyzer.entity.CurrentWeather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {
    @Autowired
    CurrentWeatherRepository currentWeatherRepository;
    @Override
    public CurrentWeather getAllCurrentWeather() {

        List<CurrentWeather> list = currentWeatherRepository.findAll();
        double avgTemp = 0;
        double avgSpeed = 0;
        double avgPressure = 0;
        int avgHumidity = 0;
        for (int i = 0; i < list.size(); i++) {
            avgTemp += list.get(i).getTemperature();
            avgSpeed += list.get(i).getSpeed();
            avgPressure += list.get(i).getPressure();
            avgHumidity += list.get(i).getHumidity();
        }
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setLocation(list.get(0).getLocation());
        currentWeather.setTemperature(avgTemp / list.size());
        currentWeather.setSpeed(avgSpeed / list.size());
        currentWeather.setPressure(avgPressure / list.size());
        currentWeather.setHumidity(avgHumidity / list.size());
        currentWeather.setConditions(list.get(list.size()-1).getConditions());



        return currentWeather;

    }

    @Override
    public CurrentWeather getLastWeather(int id) {
        CurrentWeather currentWeather = null;
        Optional<CurrentWeather> optional = currentWeatherRepository.findById(id);
        if (optional.isPresent()) {
            currentWeather = optional.get();
        }
        return currentWeather;

    }

    @Override
    public CurrentWeather getLastWet() {
        List<CurrentWeather> weathers = currentWeatherRepository.findAll();
        return weathers.get(weathers.size() - 1);
    }

    @Override
    @Transactional
    public void save(CurrentWeather currentWeather) {
        currentWeatherRepository.save(currentWeather);
    }

    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }


    private static final String WEATHER_URL =
            "https://api.openweathermap.org/data/2.5/weather?lat=53.9000000&lon=27.5666700&appid=26a348b773c390ced8ac985f4c3ff155&units=metric";

    public String startApi() {
        URL url = null;
        try {
            url = new URL(WEATHER_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        return parseUrl(url);
    }
    public CurrentWeather parseCurrentWeatherJson(String resultJson) {

        CurrentWeather currentWeather = new CurrentWeather();



        JSONObject weatherJsonObject = new JSONObject(resultJson);

        JSONObject main = (JSONObject) weatherJsonObject.get("main");
        JSONObject wind = (JSONObject) weatherJsonObject.get("wind");
        JSONArray array = weatherJsonObject.getJSONArray("weather");

        JSONObject weather = (JSONObject) array.get(0);
        currentWeather.setHumidity((main.getInt("humidity")));
        currentWeather.setSpeed(wind.getDouble("speed"));
        currentWeather.setLocation(weatherJsonObject.getString("name"));
        currentWeather.setTemperature(main.getDouble("temp"));
        currentWeather.setPressure(main.getDouble("grnd_level"));
        currentWeather.setConditions(weather.getString("main"));


        return currentWeather;
    }


}
