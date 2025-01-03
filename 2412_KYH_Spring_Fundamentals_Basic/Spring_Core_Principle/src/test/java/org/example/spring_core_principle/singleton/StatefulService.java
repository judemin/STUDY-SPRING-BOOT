package org.example.spring_core_principle.singleton;

public class StatefulService {

    // 상태를 유지하는 Field
    private int price;

    public void order(String name, int price){
        System.out.println("name: " + name + " price: " + price );
        // 아래 코드에서 문제가 발생!
        // Stateful하다
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
