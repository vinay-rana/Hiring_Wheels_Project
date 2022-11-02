package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

public interface AdminService {

	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle changeAvailability(long vehicleID,int status);
}
