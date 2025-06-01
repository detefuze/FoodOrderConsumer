package com.ru.klimashd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.ru.foodshop_entities",  // Пакет с сущностями
        "com.ru.klimashd.entities"   // Дополнительные пакеты с сущностями
})
@EnableJpaRepositories(basePackages = {
        "com.ru.klimashd.repositories"  // Пакет с репозиториями
})
public class FoodOrderConsumerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FoodOrderConsumerApplication.class, args);
    }
}
