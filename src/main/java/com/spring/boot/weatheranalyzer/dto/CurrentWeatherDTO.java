package com.spring.boot.weatheranalyzer.dto;

import java.util.Objects;

public class CurrentWeatherDTO {

    private double temperature;


    private double speed;


    private double pressure;


    private int humidity;


    private String conditions;


    private String location;


    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeatherDTO that = (CurrentWeatherDTO) o;
        return Double.compare(that.temperature, temperature) == 0 && Double.compare(that.speed, speed) == 0 && Double.compare(that.pressure, pressure) == 0 && humidity == that.humidity && Objects.equals(conditions, that.conditions) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, speed, pressure, humidity, conditions, location);
    }
}
