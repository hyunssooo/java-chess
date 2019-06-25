package chess.domain;

import chess.domain.piece.Piece;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Map;

public class BoardJson {
    Board board;

    public BoardJson(Board board) {
        this.board = board;
    }

    public JsonObject getboardJson() {
        JsonArray jsonObject = new JsonArray();
        jsonObject.add(teamJson(Team.BLACK));
        jsonObject.add(teamJson(Team.WHITE));

        JsonObject boardInfo = new JsonObject();
        boardInfo.add("Board", jsonObject);
        return boardInfo;
    }

    private JsonObject teamJson(Team team) {
        Map<Spot, Piece> teamPieces = board.getTeamPieces(team);

        JsonArray teamJson = new JsonArray();
        teamPieces.entrySet()
                .stream()
                .forEach(spotPieceEntry -> {
                    JsonObject blackTeam = new JsonObject();
                    blackTeam.addProperty("Spot", spotPieceEntry.getKey().getIndex());
                    blackTeam.addProperty("Piece", spotPieceEntry.getValue().getPieceType());
                    teamJson.add(blackTeam);
                });


        JsonObject teamInfo = new JsonObject();
        teamInfo.add(team.getTeamColor(), teamJson);
        return teamInfo;
    }
}
