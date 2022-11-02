package org.ncu.hirewheels.services;

import java.util.List;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleSubCategory;

public interface VehicleService {

	public List<Vehicle> getAllVehicles();
	
	public List<Vehicle> getAvailableVehicles(VehicleSubCategory vehicleCategory,Booking bookingDetails);
}
