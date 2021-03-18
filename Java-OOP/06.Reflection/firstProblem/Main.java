package firstProblem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getName());

        Class<? super Reflection> baseClazz = clazz.getSuperclass();

        System.out.println("class " + baseClazz.getName());
        Arrays.stream(clazz.getInterfaces()).forEach(i -> System.out.println("interface " + i.getName()));

        //making instance by the constructor without arguments
        try {
            Constructor<Reflection> constructor = clazz.getDeclaredConstructor();
            Reflection reflection = constructor.newInstance();
            System.out.println(reflection.toString());
        } catch (InstantiationException |
                InvocationTargetException |
                NoSuchMethodException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

        //making instance by the constructor with 3 arguments of type String
        //in this case our constructor is private and we cannot run the problem because of access modifier 
        try {
            Constructor<Reflection> constructor = clazz.getDeclaredConstructor(
                    String.class, String.class, String.class
            );
            Reflection reflection = constructor.newInstance("1", "2", "3");
            System.out.println(reflection.toString());
        } catch (InstantiationException |
                InvocationTargetException |
                NoSuchMethodException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
