
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
	//	StatisticDisplay sd = new StatisticDisplay(weatherData);
	//	ForecastDisplay fd = new ForecastDisplay(weatherData);
	//	HeatIndexDisplay hid = new HeatIndexDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(20, 45, 10.4f);
	}
}
