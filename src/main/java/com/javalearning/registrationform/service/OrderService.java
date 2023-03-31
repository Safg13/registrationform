package com.javalearning.registrationform.service;

import com.javalearning.registrationform.dto.OrderDto;
import com.javalearning.registrationform.model.Order;
import com.javalearning.registrationform.model.User;
import com.javalearning.registrationform.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService extends GenericService<Order> {

    private final UserService userService;

    private final OrderRepository repository;

    protected OrderService(UserService userService, OrderRepository repository) {
        super(repository);
        this.userService = userService;
        this.repository = repository;
    }

    public boolean isAppointmentExistsByDate(LocalDateTime appointmentDate) {
        LocalDateTime trimmedDate = appointmentDate.withMinute(0).withSecond(0).withNano(0);
        return repository.existsByAppointmentDate(trimmedDate);
    }

    public Order addOrder(OrderDto orderDto) {
        User user  = userService.getOne(orderDto.getUser().getId());

        Order order = Order.builder()
                .id(0L)
                .appointmentDate(orderDto.getAppointmentDate().withMinute(0).withSecond(0).withNano(0))
                .appointmentPeriod(orderDto.getAppointmentPeriod())
                .user(user)
                .build();
        return repository.save(order);
    }

}