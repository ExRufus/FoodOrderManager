package chapter1.utils;

public class FormatBarrier {
    public static StringBuilder output = new StringBuilder();

    public String oneFormatBarrier() {
        return output.append("-".repeat(31)).toString();
    }

    public String twoFormatBarrier(String text) {
        output.setLength(0);
        return output.append("=".repeat(26)).append("\n").append(text).append("\n").append("=".repeat(26)).toString();
    }

}