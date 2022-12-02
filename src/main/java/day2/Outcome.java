package day2;

public enum Outcome {
    Win {
        @Override
        public int score() {
            return 6;
        }
    },
    Draw {
        @Override
        public int score() {
            return 3;
        }
    },
    Lose {
        @Override
        public int score() {
            return 0;
        }
    };

    public abstract int score();
}
