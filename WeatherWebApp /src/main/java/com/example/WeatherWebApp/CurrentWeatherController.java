package com.example.WeatherWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrentWeatherController {

    private final StubWeatherService stubWeatherService;
    private final LiveWeatherService liveWeatherService;

    public CurrentWeatherController(StubWeatherService stubWeatherService, LiveWeatherService liveWeatherService) {
        this.stubWeatherService = stubWeatherService;
        this.liveWeatherService = liveWeatherService;
    }

    @GetMapping("/current-weather")
    public String getCurrentWeather(Model model) {
        if (true) {
            model.addAttribute("currentWeather", liveWeatherService.getCurrentWeather("Detroit","us"));
        } else {
            model.addAttribute("currentWeather", stubWeatherService.getCurrentWeather("Detroit","us"));
        }
        return "current-weather";
    }

}
