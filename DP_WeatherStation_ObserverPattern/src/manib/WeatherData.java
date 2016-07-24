package manib;

import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	public void setMeasurements(float t, float h, float p) {
		this.temperature = t;
		this.humidity = h;
		this.pressure = p;
		
		this.measurementsChanged();
	}
	
	public void measurementsChanged() {
		this.notifyObservers();
	}
	
	@Override
	public void notifyObservers() {
		for (int i=0; i<observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(this.temperature, this.humidity, this.pressure);
		}
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
}
