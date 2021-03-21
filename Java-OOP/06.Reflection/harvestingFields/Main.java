package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

		Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

		for (int i = 0; i < 100; i++) {
            String command = scanner.nextLine();
            if (command.equals("HARVEST")) {
                break;
            }
            String modifier = command;
            Field[] fields = Arrays.stream(declaredFields).filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
                    .toArray(Field[]::new);

            if (fields.length == 0){
                for (Field declaredField : declaredFields) {
                    System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers())
                    , declaredField.getType().getSimpleName(), declaredField.getName());
                }
            } else {
                printFields(fields);
            }
        }
    }

    public static void printFields(Field[] fields){
        Arrays.stream(fields).forEach(field -> System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers())
                , field.getType().getSimpleName(), field.getName()));
    }
}
