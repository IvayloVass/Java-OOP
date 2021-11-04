package lab01_abstraction.P02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rectangleCoordinates = readCoordinates(sc);
        Point pointA = new Point(rectangleCoordinates[0], rectangleCoordinates[1]);
        Point pointB = new Point(rectangleCoordinates[2], rectangleCoordinates[3]);
        Rectangle rectangle = new Rectangle(pointA, pointB);

        int coordinatesNum = Integer.parseInt(sc.nextLine());
        while (coordinatesNum-- > 0) {
            String input = sc.nextLine();
            int[] pointCoordinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int coordinateX = pointCoordinates[0];
            int coordinateY = pointCoordinates[1];
            Point point = new Point(coordinateX, coordinateY);
            System.out.println(rectangle.contains(point));

        }
    }

    private static int[] readCoordinates(Scanner sc) {
        int[] coordinates;
        coordinates = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        return coordinates;
    }
}