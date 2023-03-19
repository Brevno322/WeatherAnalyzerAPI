package com.spring.boot.weatheranalyzer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.boot.weatheranalyzer.entity.CurrentWeather;

import java.io.IOException;
import java.util.List;

public interface CurrentWeatherService {
    public CurrentWeather getAllCurrentWeather();

 //   public String openAPI() throws IOException, InterruptedException;

public void save(CurrentWeather currentWeather);
    public String startApi() throws JsonProcessingException;
    public CurrentWeather  parseCurrentWeatherJson(String resultJson);
    public CurrentWeather getLastWeather(int id) ;
    public CurrentWeather getLastWet();
}
