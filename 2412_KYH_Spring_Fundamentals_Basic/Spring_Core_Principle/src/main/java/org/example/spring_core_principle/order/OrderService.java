package org.example.spring_core_principle.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
