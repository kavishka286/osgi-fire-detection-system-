package com.sa.ecomonitor.power.monitor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.ecomonitor.power.alert.PowerAlert;
import com.sa.ecomonitor.power.solar.SolarService;
import com.sa.ecomonitor.weather.heatcontrolsensorsubscriber.HeatControlSensorService;
import com.sa.ecomonitor.weather.lightcontrolsensorsubscriber.LightControlSensorService;

public class PowerMonitorActivator implements BundleActivator {
	ServiceReference heatControlServiceReference;
	
	ServiceReference lightControlSensorServiceReference;
	
	ServiceReference solarServiceReference;
	
	ServiceReference alertServiceReference;
	
	public void start(BundleContext context) throws Exception {
		heatControlServiceReference = context.getServiceReference(HeatControlSensorService.class.getName());
		HeatControlSensorService heatControlSensorService = (HeatControlSensorService) context.getService(heatControlServiceReference);
	
		lightControlSensorServiceReference = context.getServiceReference(LightControlSensorService.class.getName());
		LightControlSensorService lightControlSensorService = (LightControlSensorService) context.getService(lightControlSensorServiceReference);
		
		solarServiceReference = context.getServiceReference(SolarService.class.getName());
		SolarService solarService = (SolarService) context.getService(solarServiceReference);
		
		alertServiceReference = context.getServiceReference(PowerAlert.class.getName());
		PowerAlert powerAlert = (PowerAlert) context.getService(alertServiceReference);
		
		PowerMonitor powerMonitor = new PowerMonitorImpl();
		powerMonitor.generateReport(heatControlSensorService, lightControlSensorService, solarService);
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}