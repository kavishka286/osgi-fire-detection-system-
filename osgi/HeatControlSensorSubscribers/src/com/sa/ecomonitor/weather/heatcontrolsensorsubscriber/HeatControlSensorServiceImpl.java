package com.sa.ecomonitor.weather.heatcontrolsensorsubscriber;

import java.util.ArrayList;
import java.util.List;

public class HeatControlSensorServiceImpl implements HeatControlSensorService {

    // List to track heaters that are turned on
    private List<String> heatersOn = new ArrayList<>();

    @Override
    public void turnOnHeater(String[] areas, int temp) {
        for (String area : areas) {
            // Simulate turning on the heater and adding the area to the list of heaters on
            System.out.println("Turning on heater in: " + area + " with target temperature: " + temp + "°C");
            heatersOn.add(area); // Track the area where the heater is on
        }
    }

    @Override
    public void turnOffHeater(String[] areas) {
        for (String area : areas) {
            // Simulate turning off the heater and removing the area from the list of heaters on
            System.out.println("Turning off heater in: " + area);
            heatersOn.remove(area); // Remove the area from the list of heaters on
        }
    }

    @Override
    public int[] getTotalHeatersOn() {
        // Return the count of heaters that are currently on (tracked in the list)
        return new int[] { heatersOn.size() };
    }
}
