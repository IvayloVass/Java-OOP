package lab07_reflectionAndAnnotations.hightQualityMistakes.codingTracker;

import java.util.Arrays;
import java.util.Comparator;



public class Tracker {
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Reflection.class);
    }

    public static void printMethodsByAuthor(Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods()).filter(method -> method.getDeclaredAnnotation(Author.class) != null)
                .sorted(Comparator.comparing(method -> method.getDeclaredAnnotation(Author.class).name()))
                .forEach(method -> {
                    System.out.println(method.getDeclaredAnnotation(Author.class).name() + ": " + method.getName());
                });

    }
}
