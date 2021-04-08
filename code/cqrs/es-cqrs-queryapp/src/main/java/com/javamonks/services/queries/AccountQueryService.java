package com.javamonks.services.queries;

import java.util.List;

import com.javamonks.entities.AccountQueryEntity;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
    public AccountQueryEntity getAccount(String accountNumber);
}
