package com.dushi.designpatterns.singleton.Prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<VehicleType, Vehicle> vehicles = new HashMap<VehicleType, Vehicle>();

    public Registry() {
        this.initialize();
    }

    public Vehicle getVehicle(VehicleType vehicleType) {
        Vehicle vehicle = null;
        try {
            vehicle = (Vehicle) vehicles.get(vehicleType).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    private void initialize() {
        Car car = new Car();
        car.setEngineCapacity(2000);
        car.setFuelType("Gasoline");
        car.setType("Mini");

        Bus bus = new Bus();
        bus.setNumberOfSeats(32);
        bus.setEngineCapacity(3000);
        bus.setFuelType("Diesal");

        vehicles.put(VehicleType.CAR, car);
        vehicles.put(VehicleType.BUS, bus);

    }
}
