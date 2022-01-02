package com.VEA.TestWeb.DAO;

import com.VEA.TestWeb.Mappers.CargoMapper;
import com.VEA.TestWeb.Mappers.ContainerMapper;
import com.VEA.TestWeb.Model.Cargo;
import com.VEA.TestWeb.Model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContainerDAO implements com.VEA.TestWeb.Interface.DAO.ContainerDAO {
        JdbcTemplate jdbcTemplate;

        private final String SQL_FIND_CONTAINER = "SELECT * FROM [dbo].[Container] " +
                                                  "LEFT JOIN [dbo].[Cargo] ON [Cargo].[IdContainer] = [Container].[Id] " +
                                                  "WHERE [Container].[Id] = ?";
        private final String SQL_DELETE_CONTAINER = "DELETE FROM [dbo].[Container] WHERE [Id] = ?";
        private final String SQL_UPDATE_CONTAINER = "UPDATE [dbo].[Container] SET [Code] = ?, [Height] = ?, [Length]  = ?, [Note] = ?, [Width] = ? WHERE [Id] = ?";
        private final String SQL_GET_ALL = "SELECT " +
                                           "[Container].[Id] ContainerId, [Container].[Code] ContainerCode, [Container].[Height] ContainerHeight, " +
                                           "[Container].[Length] ContainerLength, [Container].[Note] ContainerNote, [Container].[Width] ContainerWidth, " +
                                           "[Cargo].[Id] CargoId, [Cargo].[Amount] CargoAmount, [Cargo].[IdContainer] CargoIdContainer, " +
                                           "[Cargo].[IdMaterial] CargoIdMaterial " +
                                           "FROM [dbo].[Container] " +
                                           "LEFT JOIN [dbo].[Cargo] ON [Cargo].[IdContainer] = [Container].[Id] " +
                                           "ORDER BY [Container].[Id]";
        private final String SQL_INSERT_CONTAINER = "INSERT INTO [dbo].[Container](Code, Height, Length, Note, Width) VALUES (?,?,?,?,?)";

        private final static RowMapper<Container> containerMapper = new ContainerMapper();
        private final static RowMapper<Cargo> cargoMapper = new CargoMapper();

        @Autowired
        public ContainerDAO(DataSource dataSource) {
                jdbcTemplate = new JdbcTemplate(dataSource);
        }

        @Override
        public Container getById(int id) {
                return jdbcTemplate.queryForObject(SQL_FIND_CONTAINER, new ContainerMapper(), id);
        }

        @Override
        public List<Container> getAll() {
                return jdbcTemplate.query(SQL_GET_ALL,
                        new ResultSetExtractor<List<Container>>() {
                        public List<Container> extractData(ResultSet rs) throws SQLException, DataAccessException {
                                List<Container> containers = new ArrayList<>();
                                Container container = null;
                                int lastContainerId = -1;
                                int containerIdx = 0;
                                int cargoIdx = 0;
                                while (rs.next()) {
                                        int currentContainerId = rs.getInt("ContainerId");
                                        if (container == null || lastContainerId != currentContainerId) {
                                                lastContainerId = currentContainerId;
                                                container = containerMapper.mapRow(rs, containerIdx++);
                                                cargoIdx = 0;
                                                containers.add(container);
                                        }
                                        container.getCargo().add(cargoMapper.mapRow(rs, cargoIdx++));
                                }
                                return containers;
                        }
                });
        }

        @Override
        public boolean delete(Container entity) {
                return jdbcTemplate.update(SQL_DELETE_CONTAINER, entity.getId()) > 0;
        }

        @Override
        public boolean update(Container entity) {
                return jdbcTemplate.update(SQL_UPDATE_CONTAINER,
                        entity.getCode(),
                        entity.getHeight(),
                        entity.getLength(),
                        entity.getNote(),
                        entity.getWidth(),
                        entity.getId()) > 0;
        }

        @Override
        public boolean create(Container entity) {
                return jdbcTemplate.update(SQL_INSERT_CONTAINER,
                        entity.getCode(),
                        entity.getHeight(),
                        entity.getLength(),
                        entity.getNote(),
                        entity.getWidth()) > 0;
        }
}
