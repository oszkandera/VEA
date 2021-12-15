package com.VEA.TestWeb.Factory;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private static BasicDataSource dataSource;

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:sqlserver://localhost;databaseName=VEA");
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUsername("sa");
            dataSource.setPassword("kokos");
        }

        Connection connection = dataSource.getConnection();
        return connection;
    }
}