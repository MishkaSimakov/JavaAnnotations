package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Vector;

public class Printer {
    public static void print(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Printable.class))
                continue;

            int modifiers = field.getModifiers();

            try {
                System.out.print(field.getName() + " = " + field.get(o));

                String modifiersString = Printer.getModifiersString(modifiers);

                if (!modifiersString.isEmpty()) {
                    System.out.print(". It is " + modifiersString + " field");
                }

                System.out.println();
            } catch (IllegalAccessException e) {
                System.out.println("Field " + field.getName() + " doesn't exist");
            }
        }
    }

    private static String getModifiersString(int modifiers) {
        Vector<String> modifiersString = new Vector<>();

        if (Modifier.isPrivate(modifiers))
            modifiersString.add("private");

        if (Modifier.isFinal(modifiers))
            modifiersString.add("final");

        if (Modifier.isStatic(modifiers))
            modifiersString.add("static");

        return String.join(" and ", modifiersString);
    }
}
