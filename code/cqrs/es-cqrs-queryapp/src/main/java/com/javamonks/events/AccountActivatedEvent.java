package com.javamonks.events;

import com.javamonks.aggregates.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }

	@Override
	public String toString() {
		return "AccountActivatedEvent [status=" + status + ", id=" + id + "]";
	}
    
    
    
}
