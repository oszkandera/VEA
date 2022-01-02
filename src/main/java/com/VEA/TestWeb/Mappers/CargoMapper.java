package com.VEA.TestWeb.Mappers;

import com.VEA.TestWeb.Model.Cargo;
import com.VEA.TestWeb.Model.Container;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoMapper implements RowMapper<Cargo> {

    public Cargo mapRow(ResultSet resultSet, int i) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setId(resultSet.getInt("CargoId"));
        cargo.setAmount(resultSet.getFloat("CargoAmount"));
        return cargo;
    }
}