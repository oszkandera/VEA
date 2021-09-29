package com.VEA.TestWeb.Repository;

import com.VEA.TestWeb.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
