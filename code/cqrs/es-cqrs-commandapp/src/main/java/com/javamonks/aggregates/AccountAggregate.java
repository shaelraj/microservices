/**
 * 
 */
package com.javamonks.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.javamonks.commands.CreateAccountCommand;
import com.javamonks.commands.CreditMoneyCommand;
import com.javamonks.commands.DebitMoneyCommand;
import com.javamonks.events.AccountActivatedEvent;
import com.javamonks.events.AccountCreatedEvent;
import com.javamonks.events.AccountHeldEvent;
import com.javamonks.events.MoneyCreditedEvent;
import com.javamonks.events.MoneyDebitedEvent;

/**
 * @author shaelraj
 *
 */
@Aggregate
public class AccountAggregate {

	@AggregateIdentifier
	private String id;

	private double accountBalance;

	private String currency;

	private String status;

	public AccountAggregate() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@CommandHandler
	public AccountAggregate(CreateAccountCommand createAccountCommand) {
		AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance,
				createAccountCommand.currency));
	}

	@CommandHandler
	protected void on(CreditMoneyCommand creditMoneyCommand) {
		AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount,
				creditMoneyCommand.currency));
	}

	@CommandHandler
	protected void on(DebitMoneyCommand debitMoneyCommand) {
		AggregateLifecycle.apply(
				new MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency));
	}

	@EventSourcingHandler
	protected void on(AccountCreatedEvent accountCreatedEvent) {
		this.id = accountCreatedEvent.id;
		this.accountBalance = accountCreatedEvent.accountBalance;
		this.currency = accountCreatedEvent.currency;
		this.status = String.valueOf(Status.CREATED);

		AggregateLifecycle.apply(new AccountActivatedEvent(this.id, Status.ACTIVATED));
	}

	@EventSourcingHandler
	protected void on(AccountActivatedEvent accountActivatedEvent) {
		this.status = String.valueOf(accountActivatedEvent.status);
	}

	@EventSourcingHandler
	protected void on(MoneyCreditedEvent moneyCreditedEvent) {

		if (this.accountBalance < 0 & (this.accountBalance + moneyCreditedEvent.creditAmount) >= 0) {
			AggregateLifecycle.apply(new AccountActivatedEvent(this.id, Status.ACTIVATED));
		}

		this.accountBalance += moneyCreditedEvent.creditAmount;
	}
	
	@EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent){

        if (this.accountBalance >= 0 & (this.accountBalance - moneyDebitedEvent.debitAmount) < 0){
            AggregateLifecycle.apply(new AccountHeldEvent(this.id, Status.HOLD));
        }

        this.accountBalance -= moneyDebitedEvent.debitAmount;

    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent){
        this.status = String.valueOf(accountHeldEvent.status);
    }

}
