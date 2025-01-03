package org.example.spring_core_principle.singleton;

public class SingletonService {
    // 관례상 아래와 같이 생성한다
    // Static이기 때문에 Class 영역에 하나만 생성된다
    private static final SingletonService INSTANCE = new SingletonService();

    // JVM에 Java가 올라갈 때
    // 내부적으로 자기 자신의 INSTANCE 객체를 생성해둔다
    // 객체를 조회하는 것은 getInstance()만으로 가능하다
    // 해당 메소드를 호출하면 항상 같은 객체를 반환한다
    public static SingletonService getInstance() {
        return INSTANCE;
    }

    // private 생성자를 통해서
    // 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다
    private SingletonService() {

    }

    public void logic(){
        System.out.println("Singleton 객체 로직 호출");
    }
}
