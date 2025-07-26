package com.sa.ecomonitor.power.monitor;

import com.sa.ecomonitor.power.solar.SolarService;
import com.sa.ecomonitor.weather.heatcontrolsensorsubscriber.HeatControlSensorService;
import com.sa.ecomonitor.weather.lightcontrolsensorsubscriber.LightControlSensorService;

public interface PowerMonitor {
	public float calculatePower(HeatControlSensorService heatControlSensorService, LightControlSensorService lightControlSensorService, SolarService solarService);
	
	public void generateReport(HeatControlSensorService heatControlSensorService, LightControlSensorService lightControlSensorService, SolarService solarService);
}