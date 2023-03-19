package com.spring.boot.weatheranalyzer.dao;

import com.spring.boot.weatheranalyzer.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather,Integer> {


}
