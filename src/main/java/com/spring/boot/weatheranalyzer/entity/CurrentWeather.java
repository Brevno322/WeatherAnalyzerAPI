package com.spring.boot.weatheranalyzer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



import java.util.Objects;

@Entity
@Table(name = "current_weather")
public class CurrentWeather {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "temperature")
    private double temperature;
    @Column(name = "speed")
    private double speed;
    @Column(name = "pressure")
    private double pressure;
    @Column(name = "humidity")
    private int humidity;
    @Column(name = "conditions")
    private String conditions;

    @Column(name = "location")
    private String location;

    public CurrentWeather() {
    }

    public CurrentWeather(int id, double temperature, double speed, double pressure, int humidity, String conditions, String location) {
        this.id = id;
        this.temperature = temperature;
        this.speed = speed;
        this.pressure = pressure;
        this.humidity = humidity;
        this.conditions = conditions;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        CurrentWeather that = (CurrentWeather) o;
        return id == that.id && Double.compare(that.temperature, temperature) == 0 && Double.compare(that.speed, speed) == 0 && Double.compare(that.pressure, pressure) == 0 && humidity == that.humidity && Objects.equals(conditions, that.conditions) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, speed, pressure, humidity, conditions, location);
    }
}
