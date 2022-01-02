package com.VEA.TestWeb.Mappers;

import com.VEA.TestWeb.Model.Container;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContainerMapper implements RowMapper<Container> {

    public Container mapRow(ResultSet resultSet, int i) throws SQLException {
        Container container = new Container();
        container.setId(resultSet.getInt("ContainerId"));
        container.setCode(resultSet.getString("ContainerCode"));
        container.setHeight(resultSet.getFloat("ContainerHeight"));
        container.setLength(resultSet.getFloat("ContainerLength"));
        container.setWidth(resultSet.getFloat("ContainerWidth"));
        container.setNote(resultSet.getString("ContainerNote"));
        return container;
    }
}