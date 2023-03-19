package com.spring.boot.weatheranalyzer.converter;

import com.spring.boot.weatheranalyzer.dto.CurrentWeatherDTO;
import com.spring.boot.weatheranalyzer.entity.CurrentWeather;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherConverter {

    public CurrentWeather convertFromEntity(CurrentWeatherDTO currentWeatherDTO){
        CurrentWeather currentWeather=new CurrentWeather();

     //   currentWeather.setId(currentWeatherDTO.getId());
     //   currentWeather.setDataWeather(currentWeatherDTO.getDateWeather());
        currentWeather.setTemperature(currentWeatherDTO.getTemperature());
        currentWeather.setConditions(currentWeatherDTO.getConditions());
        currentWeather.setHumidity(currentWeatherDTO.getHumidity());
        currentWeather.setPressure(currentWeatherDTO.getPressure());
        currentWeather.setSpeed(currentWeatherDTO.getSpeed());
        currentWeather.setLocation(currentWeatherDTO.getLocation());
        return currentWeather;
    }

    public CurrentWeatherDTO convertFromDTO(CurrentWeather currentWeather){
        CurrentWeatherDTO currentWeatherDTO=new CurrentWeatherDTO();

//        currentWeatherDTO.setId(currentWeather.getId());
      //  currentWeatherDTO.setDateWeather(currentWeather.getDataWeather());
        currentWeatherDTO.setConditions(currentWeather.getConditions());
        currentWeatherDTO.setTemperature(currentWeather.getTemperature());
        currentWeatherDTO.setHumidity(currentWeather.getHumidity());
        currentWeatherDTO.setPressure(currentWeather.getPressure());
        currentWeatherDTO.setSpeed(currentWeather.getSpeed());
        currentWeatherDTO.setLocation(currentWeather.getLocation());
        return currentWeatherDTO;
    }
}

