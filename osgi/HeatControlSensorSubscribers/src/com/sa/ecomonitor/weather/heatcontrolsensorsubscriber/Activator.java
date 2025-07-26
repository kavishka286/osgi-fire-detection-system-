package com.sa.ecomonitor.weather.heatcontrolsensorsubscriber;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.sa.ecomonitor.weather.WeatherService;

public class Activator implements BundleActivator {

    private ServiceReference weatherServiceRef;
    private ServiceRegistration sensorService;

    private String[] area = {"hall 1", "hall 2", "hall 3", "hall 4"};

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Heater Controller Starting!");
        
        // Create instance of HeatControlSensorService implementation
        HeatControlSensorService heaterControl = new HeatControlSensorServiceImpl();
        
        // Get weather service reference
        weatherServiceRef = context.getServiceReference(WeatherService.class);
        
        if (weatherServiceRef != null) {
            // Safely cast the service reference to WeatherService
            WeatherService weatherService = (WeatherService) context.getService(weatherServiceRef);
            
            if (weatherService != null) {
                // Get temperature from the weather service
                float temperature = weatherService.getTemprature();
                int tempInt = Math.round(temperature); // Round the temperature to an integer
                
                // Control the heater based on the temperature
                if (temperature < 20) {
                    System.out.println("Temperature is low (" + temperature + "°C), turning on heater to 24°C!");
                    heaterControl.turnOnHeater(area, 24); // Target temperature 24°C
                } else {
                    System.out.println("Temperature is normal (" + temperature + "°C), turning heater off.");
                    heaterControl.turnOffHeater(area);
                }
            } else {
                System.out.println("Weather service unavailable!");
            }
        } else {
            System.out.println("Weather service not found!");
        }
        
        // Register the HeatControlSensorService
        sensorService = context.registerService(HeatControlSensorService.class.getName(), heaterControl, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // Unregister the weather service reference
        context.ungetService(weatherServiceRef);
        System.out.println("Heater Controller Stopping!");
    }
}
