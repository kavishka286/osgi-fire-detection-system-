
package com.sa.ecomonitor.weather;

public interface WeatherService {
	public void setTemperature(float temp);
	public void setLightIntensity(float intensity);
	float getLightIntensity();
	float getTemprature();
	
}
