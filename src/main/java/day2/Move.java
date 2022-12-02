package day2;

public enum Move {
    ROCK {
        @Override
        public int score() {
            return 1;
        }
    },
    PAPER {
        @Override
        public int score() {
            return 2;
        }
    },
    SCISSORS {
        @Override
        public int score() {
            return 3;
        }
    };

    public abstract int score();
}
