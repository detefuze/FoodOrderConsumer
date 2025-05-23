package com.ru.klimashd.components;

import com.ru.klimashd.dto.BasketDTO;
import com.ru.klimashd.services.OrderConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Consumer {
    private final OrderConsumerService orderService;
    private final static Logger log = LoggerFactory.getLogger(Consumer.class);

    public Consumer(OrderConsumerService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(
            topics = "food.order.topic",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(@Payload List<BasketDTO> order, Acknowledgment ack) {
        try {
            log.info("Received message: {}", order);

            // Обработка и сохранение в БД
            orderService.processOrder(order);

            // Подтверждение обработки (сообщение удаляется из топика)
            ack.acknowledge();
            log.info("Message processed and committed");
        } catch (Exception e) {
            log.error("Error processing order: {}", e.getMessage());
        }
    }
}