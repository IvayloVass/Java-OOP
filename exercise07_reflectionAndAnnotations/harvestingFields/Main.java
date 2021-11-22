package exercise07_reflectionAndAnnotations.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> richSoilLand = Class.forName("exercise07_reflectionAndAnnotations.harvestingFields.RichSoilLand");

        Scanner sc = new Scanner(System.in);

        String accessModifierType = sc.nextLine();

        Field[] declaredFields = richSoilLand.getDeclaredFields();
        while (!accessModifierType.equals("HARVEST")) {
            Arrays.stream(declaredFields).forEach(field -> field.setAccessible(true));

            switch (accessModifierType) {
                case "private":
                    Arrays.stream(declaredFields).filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(Main::printFiled);
                    break;
                case "public":
                    Arrays.stream(declaredFields).filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(Main::printFiled);
                    break;
                case "protected":
                    Arrays.stream(declaredFields).filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(Main::printFiled);
                    break;
                case "all":
                    Arrays.stream(declaredFields)
                            .forEach(Main::printFiled);
                    break;

            }
            accessModifierType = sc.nextLine();
        }

    }

    private static void printFiled(Field field) {
        System.out.printf("%s %s %s\n",
                Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
    }
}

