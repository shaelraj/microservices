package com.javamonks.services.commands;

import java.util.concurrent.CompletableFuture;

import com.javamonks.dto.OrderCreateDTO;

public interface OrderCommandService {

    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);

}
