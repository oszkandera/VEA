package com.VEA.TestWeb.Repository;

import com.VEA.TestWeb.Model.Material;
import com.VEA.TestWeb.Model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> { }
