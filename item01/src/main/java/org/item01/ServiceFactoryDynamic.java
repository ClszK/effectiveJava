package org.item01;

public class ServiceFactoryDynamic {

    public static MyService load(String implClassName) {
        try {
            Class<?> cls = Class.forName(implClassName);
            return (MyService) cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Service: " + implClassName, e);
        }
    }
}
