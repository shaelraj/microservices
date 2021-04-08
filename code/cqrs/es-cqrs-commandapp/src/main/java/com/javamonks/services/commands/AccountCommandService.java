package com.javamonks.services.commands;

import java.util.concurrent.CompletableFuture;

import com.javamonks.dto.commands.AccountCreateDTO;
import com.javamonks.dto.commands.MoneyCreditDTO;
import com.javamonks.dto.commands.MoneyDebitDTO;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
