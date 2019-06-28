package chess.dto;

public class RoundDto {
    private int round;
    private int from;
    private int to;

    public int getRound() {
        return round;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public static class Builder implements Buildable {
        private int round;
        private int from;
        private int to;

        public Builder() {
        }

        public Builder round(int round) {
            this.round = round;
            return this;
        }

        public Builder from(int from) {
            this.from = from;
            return this;
        }

        public Builder to(int to) {
            this.to = to;
            return this;
        }

        @Override
        public RoundDto build() {
            return new RoundDto(this);
        }
    }

    public RoundDto(Builder builder) {
        this.round = builder.round;
        this.from = builder.from;
        this.to = builder.to;
    }

}
