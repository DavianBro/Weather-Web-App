package com.example.WeatherWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrentWeatherController {

    private final StubWeatherService stubWeatherService;
    private final LiveWeatherService liveWeatherService;
    private final SplitWrapper splitWrapper;

    public CurrentWeatherController(StubWeatherService stubWeatherService, LiveWeatherService liveWeatherService, SplitWrapper splitWrapper) {
        this.stubWeatherService = stubWeatherService;
        this.liveWeatherService = liveWeatherService;
        this.splitWrapper = splitWrapper;
    }

    @GetMapping("/current-weather")
    public String getCurrentWeather(Model model) {
        if (splitWrapper.isTreatmentOn("live-weather")) {
            model.addAttribute("currentWeather", liveWeatherService.getCurrentWeather("Detroit","us"));
        } else {
            model.addAttribute("currentWeather", stubWeatherService.getCurrentWeather("Detroit","us"));
        }
        return "current-weather";
    }
}

// ./gradlew build bootRun