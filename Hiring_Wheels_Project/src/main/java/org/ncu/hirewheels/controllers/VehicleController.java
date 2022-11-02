package org.ncu.hirewheels.controllers;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value="/hirewheels/v1/vehicles")
	public ResponseEntity<List<Vehicle>> getVehicles(){
		return ResponseEntity.ok(vehicleService.getAllVehicles());
	}
	
	
}
