package com.example.WeatherWebApp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CurrentWeather implements Serializable {

    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

    CurrentWeather() {
        // Default Constructor
    }

    // Constructor
    public CurrentWeather(String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed) {
        this.temperature = temperature;
        this.description = description;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
    }

    // Getters

    public BigDecimal getFeelsLike() {
        return feelsLike;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    // Setters

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public void setFeelsLike(BigDecimal feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    // Methods

// Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeather that = (CurrentWeather) o;
        return Objects.equals(description, that.description) && Objects.equals(temperature, that.temperature) && Objects.equals(feelsLike, that.feelsLike) && Objects.equals(windSpeed, that.windSpeed);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(description, temperature, feelsLike, windSpeed);
    }
}
