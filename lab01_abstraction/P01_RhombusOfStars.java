package lab01_abstraction;

import java.util.Scanner;

public class P01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = readEntry(sc);
        String rhombus = buildRhombus(size);
        printRhombus(rhombus);
    }

    private static void printRhombus(String rhombus) {
        System.out.println(rhombus);
    }

    private static String buildRhombus(int size) {
        StringBuilder builder = new StringBuilder();
        for (int row = 1; row <= size; row++) {
            builder.append(printLine(size - row, row)).append(System.lineSeparator());

        }
        for (int r = size - 1; r > 0; r--) {
            builder.append(printLine(size - r, r)).append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static String printLine(int spaces, int stars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            builder.append(" ");
        }
        for (int i = 0; i < stars; i++) {
            builder.append("* ");
        }

        return builder.toString();
    }

    private static int readEntry(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }
}