package com.ru.klimashd.mappers;

import com.ru.klimashd.dto.BasketDTO;
import com.ru.klimashd.entities.CustomerOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperToOrder {

    public CustomerOrder mapToOrder(String basketDTO) {
        CustomerOrder order = new CustomerOrder();
        order.setOrder_info(basketDTO);
        return order;
    }

    public CustomerOrder mapListBasketToOrder(List<BasketDTO> basket) {
        return mapToOrder(basket.toString());
    }
}
