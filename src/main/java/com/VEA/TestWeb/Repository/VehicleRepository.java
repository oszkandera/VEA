package com.VEA.TestWeb.Repository;

import com.VEA.TestWeb.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> { }
