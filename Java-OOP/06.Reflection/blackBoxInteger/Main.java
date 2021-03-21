package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Constructor<BlackBoxInt> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

            Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();
            Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            String line;
            while (!"END".equals(line = scanner.nextLine())){
                String[] tokens = line.split("_");
                String command = tokens[0];
                int parameter = Integer.parseInt(tokens[1]);

                //не връща метод, който директно да се ползва. Връща примерно private void add (int)
                Method method = Arrays.stream(declaredMethods).filter(n -> n.getName().equals(command))
                        .findFirst().get();

                method.setAccessible(true);
                method.invoke(blackBoxInt, parameter);

                System.out.println(innerValue.getInt(blackBoxInt));
            }

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
