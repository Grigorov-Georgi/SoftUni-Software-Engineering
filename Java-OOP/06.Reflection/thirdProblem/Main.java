package thirdProblem;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static class MethodComparator implements Comparator<Method>{

        @Override
        public int compare(Method o1, Method o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        try {
            Method[] declaredMethods = clazz.getDeclaredMethods();
            Set<Method> getters = new TreeSet<>(new MethodComparator());
            Set<Method> setters = new TreeSet<>(new MethodComparator());

            Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                    .sorted(Comparator.comparing(Field::getName))
                    .forEach(field -> System.out.println(field.getName() + " must be private!"));

            for (Method m : declaredMethods) {
                if (m.getName().contains("get")){
                    getters.add(m);
                }else if (m.getName().contains("set")){
                    setters.add(m);
                }
            }

            for (Method getter : getters) {
                if (!Modifier.isPublic(getter.getModifiers())){
                    System.out.println(getter.getName() + " have to be public!");
                }
            }

            for (Method setter : setters) {
                if (!Modifier.isPrivate(setter.getModifiers())){
                    System.out.println(setter.getName() + " have to be private!");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
