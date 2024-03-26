package me.dio.sdw2024.adapters.out;

import me.dio.sdw2024.domain.model.Champions;
import me.dio.sdw2024.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ChampionsJDBCRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;
    private RowMapper<Champions> rowMapper;

    public ChampionsJDBCRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }
    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS",rowMapper);
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
        Champions champions = jdbcTemplate.queryForObject(sql,rowMapper);
        return Optional.ofNullable(champions);
    }
}
