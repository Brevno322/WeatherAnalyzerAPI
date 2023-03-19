package com.spring.boot.weatheranalyzer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.boot.weatheranalyzer.converter.CurrentWeatherConverter;
import com.spring.boot.weatheranalyzer.dto.CurrentWeatherDTO;
import com.spring.boot.weatheranalyzer.service.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WeatherController {
    @Autowired
    private CurrentWeatherService currentWeatherService;
    @Autowired
    private CurrentWeatherConverter converter;

    @GetMapping("/weather")//Возвращает средние значения из БД
    public CurrentWeatherDTO showAllWeather() {
        CurrentWeatherDTO currentWeatherDTO =
                converter.convertFromDTO(currentWeatherService.getAllCurrentWeather());
        return currentWeatherDTO;
    }

    @Scheduled(initialDelay = 10000,fixedDelay = 10000)
    @PostMapping("/add")//Добавляет свежие данные в БД(Самостоятельно)
    public void save(){
        try {
            currentWeatherService.save
                    (currentWeatherService.parseCurrentWeatherJson(currentWeatherService.startApi()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/last/{id}")//выводит определенную погоду из БД по ID
    public CurrentWeatherDTO getWeather(@PathVariable int id) {
        CurrentWeatherDTO currentWeatherDTO =
                converter.convertFromDTO(currentWeatherService.getLastWeather(id));
        return currentWeatherDTO;
    }

    @GetMapping("/last")//Выводит самую актуальную погоду из БД
    public CurrentWeatherDTO getLa() {
        CurrentWeatherDTO currentWeatherDTO =
                converter.convertFromDTO(currentWeatherService.getLastWet());
        return currentWeatherDTO;
    }

}
