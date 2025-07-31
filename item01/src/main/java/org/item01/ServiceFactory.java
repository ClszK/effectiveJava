package org.item01;

public class ServiceFactory {

    public static Service create() {
        return new ServiceImpl();
    }

}
