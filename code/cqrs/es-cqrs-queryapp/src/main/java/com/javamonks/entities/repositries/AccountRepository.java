package com.javamonks.entities.repositries;

import org.springframework.data.repository.CrudRepository;

import com.javamonks.entities.AccountQueryEntity;

public interface AccountRepository extends CrudRepository<AccountQueryEntity, String> {
}
