/**
 * 
 */
package com.javamonks.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author shaelraj
 *
 */
public class CreateOrderCommand {
	
	@TargetAggregateIdentifier
	public final String orderId;

	public final String itemType;

	public final BigDecimal price;

	public final String currency;

	public final String orderStatus;

	/**
	 * @param orderId
	 * @param itemType
	 * @param price
	 * @param currency
	 * @param orderStatus
	 */
	public CreateOrderCommand(String orderId, String itemType, BigDecimal price, String currency, String orderStatus) {
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}
}
