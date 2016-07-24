package manib;

public class WeatherStation {
	
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionDisplay condDisplay = new CurrentConditionDisplay(weatherData);
		HeatIndexDisplay heatDisplay = new HeatIndexDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 63.5F);
	}
}
