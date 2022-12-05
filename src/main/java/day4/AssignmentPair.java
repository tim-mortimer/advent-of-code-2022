package day4;

public record AssignmentPair(Range firstElf, Range secondElf) {
    public static AssignmentPair from(String line) {
        String[] splitLine = line.split(",");
        return new AssignmentPair(Range.from(splitLine[0]), Range.from(splitLine[1]));
    }

    public boolean hasInclusiveRange() {
        return firstElf.contains(secondElf) || secondElf.contains(firstElf);
    }

    public boolean hasOverlappingAssignment() {
        return firstElf.overlaps(secondElf);
    }
}
