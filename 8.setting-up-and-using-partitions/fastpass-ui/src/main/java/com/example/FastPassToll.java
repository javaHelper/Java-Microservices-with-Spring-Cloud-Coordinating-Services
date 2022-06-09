package com.example;

public class FastPassToll {

    private String fastPassId;
    private String stationId;
    private Float amountPaid;
    
    public FastPassToll() {
    }
    public FastPassToll(String fastPassId, String stationId, Float amountPaid) {
        this.fastPassId = fastPassId;
        this.stationId = stationId;
        this.amountPaid = amountPaid;
    }
    public String getFastPassId() {
        return fastPassId;
    }
    public Float getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(Float amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getStationId() {
        return stationId;
    }
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }
    public void setFastPassId(String fastPassId) {
        this.fastPassId = fastPassId;
    }
    
}
