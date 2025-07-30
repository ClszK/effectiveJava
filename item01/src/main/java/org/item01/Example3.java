package org.item01;

interface Service {
    void execute();
}

class ServiceFactory {
    public static Service create() {
        return new ServiceImpl();
    }

    private static class ServiceImpl implements Service {
        @Override
        public void execute() {
            System.out.println("ServiceImpl 실행");
        }
    }
}

/**
 * 반환 타입의 하위 타입 객체를 반환하기
 */
public class Example3 {
    public static void main(String[] args) {
        Service service = ServiceFactory.create();
        service.execute();
    }
}
