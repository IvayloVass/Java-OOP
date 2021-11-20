package lab07_reflectionAndAnnotations.gettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflection> reflection = Reflection.class;

//        System.out.println(reflection);
//        System.out.println(reflection.getSuperclass());
//        Class<?>[] interfaces = reflection.getInterfaces();
//        Arrays.stream(interfaces).forEach(System.out::println);
//
//        lab07_reflectionAndAnnotations.GettersAndSetters.lab07_reflectionAndAnnotations.hightQualityMistakes.codingTracker.Reflection reflectionObj = reflection.getDeclaredConstructor().newInstance();
//        System.out.println(reflectionObj);

        Method[] methods = reflection.getDeclaredMethods();

        List<Method> getterList = new ArrayList<>();
        Map<String, Class<?>[]> setterMap = new TreeMap<>();

        for (Method method : methods) {
            method.setAccessible(true);
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                getterList.add(method);
            } else if (methodName.startsWith("set")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                setterMap.putIfAbsent(methodName, parameterTypes);
            }
        }
        getterList.sort(Comparator.comparing(Method::getName));
        getterList.forEach(name -> System.out.printf("%s will return class %s\n", name.getName(), name.getReturnType().getName()));

        setterMap.entrySet().forEach(setter -> {
            Class<?>[] values = setter.getValue();
            for (Class<?> value : values) {
                System.out.printf("%s and will set filed of class %s\n", setter.getKey(), value.getSimpleName());
            }
        });


    }
}
