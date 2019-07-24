package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hello.value.weather.OpenWeather;
import hello.value.weather.WeatherResponse;

@RestController
public class WeatherController {

	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

	@GetMapping("/weather")
	public OpenWeather getWeather() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(
				"https://api.openweathermap.org/data/2.5/weather?q=Milano,IT&appId=e34215066cd7d02d9cbcfbd322eefc28",
				OpenWeather.class);
	}

	// 1.estrarre località e api key in variabili
	@GetMapping("/weather/all")
	public OpenWeather getWeather1() {
		RestTemplate restTemplate = new RestTemplate();

		final String key = "e34215066cd7d02d9cbcfbd322eefc28"; // final per dire che e ostatnte enn cambia!
		String locality = "Milano,It";
		return restTemplate.getForObject(
				"https://api.openweathermap.org/data/2.5/weather?q=" + locality + "&appId=" + key, OpenWeather.class);
	}

//2. ottenere località come parametro della request
	@GetMapping("/weather/{city}")
	public OpenWeather getLocalityWeather(@PathVariable String city) {
		RestTemplate restTemplate = new RestTemplate();
		final String key = "e34215066cd7d02d9cbcfbd322eefc28";
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appId=" + key,
				OpenWeather.class);
	}

	// METODO ALTERNATIVO!! su postman /weather?city=Milano,it
//	@GetMapping("/weather")
//	public OpenWeather getLocalityWeather1(@PathVariable("city") String city) {
//		RestTemplate restTemplate = new RestTemplate();
//		final String key = "e34215066cd7d02d9cbcfbd322eefc28";
//		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appId=" + key,
//				OpenWeather.class);
//	}

	// 3. doppia interrogazione*
	@GetMapping("/weather/2cities")
	public WeatherResponse get2LocalitiesWeather(@RequestParam("city1") String city1,
			@RequestParam("city2") String city2) {
		RestTemplate restTemplate = new RestTemplate();

		final String key = "e34215066cd7d02d9cbcfbd322eefc28";
		String url1 = "https://api.openweathermap.org/data/2.5/weather?q=" + city1 + "&appId=" + key;
		String url2 = "https://api.openweathermap.org/data/2.5/weather?q=" + city2 + "&appId=" + key;

		log.debug("Fetch url1:url1"); // serve a stampare nel debug cosi nn mi lo sda errore
		log.debug("Fetch url2:url2");

		OpenWeather weather1 = restTemplate.getForObject(url1, OpenWeather.class);
		OpenWeather weather2 = restTemplate.getForObject(url2, OpenWeather.class);

		WeatherResponse response = new WeatherResponse();
		response.setFirstcity(weather1.getName());
		response.setSecondtcity(weather2.getName());
		response.setFirsttemp(weather1.getMain().getTemp() - 273.15);
		response.setSecondtemp(weather2.getMain().getTemp() - 273.15);

		return response;

	}
}