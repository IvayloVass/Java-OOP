package exercise07_reflectionAndAnnotations.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> ctr = blackBoxIntClass.getDeclaredConstructor();
        ctr.setAccessible(true);
        BlackBoxInt blackBoxInt = ctr.newInstance();

        Method[] declaredMethods = blackBoxIntClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
        }

        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method method = getCurrentMethod(declaredMethods, command);
            method.invoke(blackBoxInt, value);
            System.out.println(innerValue.get(blackBoxInt));

            input = sc.nextLine();
        }

    }

    private static Method getCurrentMethod(Method[] declaredMethods, String command) {
        Method method = Arrays.stream(declaredMethods)
                .filter(m -> m.getName().startsWith(command))
                .findFirst().orElse(null);
        return method;
    }
}
