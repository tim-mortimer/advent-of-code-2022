package day4;

public record Range(int left, int right) {
    public static Range from(String range) {
        String[] splitRange = range.split("-");
        return new Range(Integer.parseInt(splitRange[0]), Integer.parseInt(splitRange[1]));
    }

    public boolean contains(Range elf) {
        return left <= elf.left() && right >= elf.right();
    }

    public boolean overlaps(Range elf) {
        return right >= elf.left && left <= elf.right;
    }
}
