package org.knit.lab9;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Есть аннотация NotNull");
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                System.out.println("Есть аннотация MaxLength");
                if (value instanceof String) {
                    int maxLength = field.getAnnotation(MaxLength.class).value();
                    if (((String) value).length() > maxLength) {
                        throw new ValidationException("Длина строки " + field.getName() + " не должна быть больше " + maxLength + ".");
                    }
                }
                else {
                    throw new IllegalArgumentException("Аннотация @MaxLength применяется только к полям типа String.");
                }
            }


            if (field.isAnnotationPresent(Min.class)) {
                System.out.println("Есть аннотация Min");
                if (value instanceof Integer) {
                    int minValue = field.getAnnotation(Min.class).value();
                    if ((int) value < minValue) {
                        throw new ValidationException("Число " + field.getName() + " должно быть больше или равно " + minValue + ".");
                    }
                }
                else {
                    throw new IllegalArgumentException("Аннотация @Min применяется только к полям типа int.");
                }
            }

            if (field.isAnnotationPresent(Range.class)) {
                if (value instanceof Integer) {
                    int minValue = field.getAnnotation(Range.class).min();
                    int maxValue = field.getAnnotation(Range.class).max();
                    if ((int) value < minValue || (int) value > maxValue) {
                        throw new ValidationException("Число " + field.getName() + " должно быть в интервале [" + minValue + "; " + maxValue + "].");
                    }
                }
                else {
                    throw new IllegalArgumentException("Аннотация @Range применяется только к полям типа int.");
                }
            }
        }
    }
}
