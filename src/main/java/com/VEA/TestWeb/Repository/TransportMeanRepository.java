package com.VEA.TestWeb.Repository;

import com.VEA.TestWeb.Model.TransportMean;
import com.VEA.TestWeb.Model.Vehicle;
import org.springframework.boot.rsocket.server.RSocketServer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportMeanRepository extends JpaRepository<TransportMean, Integer> { }
