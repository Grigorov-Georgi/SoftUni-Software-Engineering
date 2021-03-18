package secondProblem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

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

            for (Method m : declaredMethods) {
                if (m.getName().contains("get")){
                    getters.add(m);
                }else if (m.getName().contains("set")){
                    setters.add(m);
                }
            }

            for (Method getter : getters) {
                System.out.println(getter.getName() + " will return " + getter.getReturnType().getName());
            }

            for (Method setter : setters) {
                System.out.println(setter.getName() + " and will set field of " + setter.getParameterTypes()[0]);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
