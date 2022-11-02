package org.ncu.hirewheels.DAO;

import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleDAO extends JpaRepository<Vehicle,Long> {
	
}
