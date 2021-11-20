package lab07_reflectionAndAnnotations.hightQualityMistakes.codingTracker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflection> reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        List<String> gettersList = new ArrayList<>();
        List<String> settersList = new ArrayList<>();
        List<String> fieldList = new ArrayList<>();

        for (Method method : methods) {
            method.setAccessible(true);
            int modifiers = method.getModifiers();
            if (method.getName().startsWith("get") && !Modifier.toString(modifiers).startsWith("public")) {
                gettersList.add(method.getName());
            } else if (method.getName().startsWith("set") && !Modifier.toString(modifiers).startsWith("private"))
                settersList.add(method.getName());
        }

        Field[] fields = reflection.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            int modifiers = field.getModifiers();
            if (!Modifier.toString(modifiers).startsWith("private")) {
                fieldList.add(field.getName());
            }
        }

        fieldList.stream().sorted(String::compareTo).forEach(name -> System.out.printf("%s must be private!\n", name));
        gettersList.stream().sorted(String::compareTo).forEach(name -> System.out.printf("%s have to be public!\n", name));
        settersList.stream().sorted(String::compareTo).forEach(name -> System.out.printf("%s have to be private!\n", name));


    }
}
