package day3;

public record Priority(char character) {
    public static Priority of(char character) {
        return new Priority(character);
    }

    public int value() {
        int decimalUnicodeValue = character;

        if (decimalUnicodeValue >= 97) {
            return decimalUnicodeValue - 96;
        } else {
            return decimalUnicodeValue - 38;
        }
    }
}
