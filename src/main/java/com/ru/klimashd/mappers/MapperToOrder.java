package com.ru.klimashd.mappers;

import com.ru.klimashd.entities.CustomerOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperToOrder {

    public CustomerOrder mapToOrder(BasketDTO basketDTO) {
        CustomerOrder order = new CustomerOrder();
        order.setOrder_id((basketDTO.getId()));
        order.setName(basketDTO.getName());
        order.setAmount(basketDTO.getAmount());
        order.setPrice(basketDTO.getPrice());
        order.setProductType(basketDTO.getProduct_type());
        order.setId_product(basketDTO.getId_product());
        return order;
    }

    public List<CustomerOrder> mapListBasketToListOrder(List<BasketDTO> basket) {
        List<CustomerOrder> orderList = new ArrayList<>();

        for (BasketDTO pos : basket) {
            orderList.add(mapToOrder(pos));
        }

        return orderList;
    }
}
