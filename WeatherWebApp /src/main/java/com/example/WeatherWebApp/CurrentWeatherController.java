package com.example.WeatherWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.Applet;
import java.io.IOException;

@Controller
public class CurrentWeatherController extends HttpServlet {

    private final StubWeatherService stubWeatherService;
    private final LiveWeatherService liveWeatherService;
    private final SplitWrapper splitWrapper;

    // Declare GET Variable

    /*

     Private String cityName =

     */


    public CurrentWeatherController(StubWeatherService stubWeatherService, LiveWeatherService liveWeatherService, SplitWrapper splitWrapper) {
        this.stubWeatherService = stubWeatherService;
        this.liveWeatherService = liveWeatherService;
        this.splitWrapper = splitWrapper;
    }


    @GetMapping("/current-weather")
    public String getCurrentWeather(HttpServletRequest request, HttpServletResponse response, Model model)
    throws ServletException, IOException {

       String City = request.getParameter("City");
        if (splitWrapper.isTreatmentOn("live-weather")) {
            model.addAttribute("currentWeather", liveWeatherService.getCurrentWeather(City,"us"));
        } else {
            model.addAttribute("currentWeather", stubWeatherService.getCurrentWeather(City ,"us"));
        }
        return "current-weather";
    }
}
/// If City not found
// Put weather city name in current-weather.html
// Backbutton
// Different images dependent on weather.
// ./gradlew build bootRun