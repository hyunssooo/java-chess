package chess.dao;

import chess.dto.RoundDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoundDaoImpl implements RoundDao {
    private static RoundDaoImpl roundDaoImpl;

    private RoundDaoImpl() {
    }

    public static RoundDaoImpl getInstance() {
        if (roundDaoImpl == null) {
            roundDaoImpl = new RoundDaoImpl();
        }
        return roundDaoImpl;
    }

    public void addRound(RoundDto roundDto) {
        PreparedStatementSetter pss = preparedStatement -> {
            preparedStatement.setInt(1, roundDto.getRound());
            preparedStatement.setInt(2, roundDto.getFrom());
            preparedStatement.setInt(3, roundDto.getTo());
        };
        JdbcTemplate template = new JdbcTemplate();
        String query = "INSERT INTO game (round, start, target) VALUES (?, ?, ?)";
        template.executeUpdate(query, pss);
    }

    public List<RoundDto> selectRound() {
        RowMapper rowMapper = new RowMapper() {
            @Override
            public List<RoundDto> mapRow(ResultSet resultSet) throws SQLException {
                List<RoundDto> roundDtos = new ArrayList<>();
                while (resultSet.next()) {
                    int round = resultSet.getInt("round");
                    int start = resultSet.getInt("start");
                    int target = resultSet.getInt("target");
                    RoundDto roundDto = new RoundDto(round, start, target);

                    roundDtos.add(roundDto);
                }
                return roundDtos;
            }
        };
        JdbcTemplate template = new JdbcTemplate();
        String query = "SELECT round, start, target FROM game ORDER BY round ASC";

        return template.executeQuery(query, rowMapper);
    }
}