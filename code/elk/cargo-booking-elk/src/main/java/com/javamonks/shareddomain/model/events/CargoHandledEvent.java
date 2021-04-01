package com.javamonks.shareddomain.model.events;

public class CargoHandledEvent {
    private CargoHandledEventData cargoHandledEventData;
    public CargoHandledEvent(){}
    public CargoHandledEvent(CargoHandledEventData cargoHandledEventData){
        this.cargoHandledEventData = cargoHandledEventData;
    }
    public CargoHandledEventData getCargoHandledEventData() {
        return this.cargoHandledEventData;
    }
	public void setCargoHandledEventData(CargoHandledEventData cargoHandledEventData) {
		this.cargoHandledEventData = cargoHandledEventData;
	}
    
    
}
