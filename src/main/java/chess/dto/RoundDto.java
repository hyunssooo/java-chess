package chess.dto;

public class RoundDto {
    private int round;
    private int from;
    private int to;

    public RoundDto(int round, int from, int to) {
        this.round = round;
        this.from = from;
        this.to = to;
    }

    public int getRound() {
        return round;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
