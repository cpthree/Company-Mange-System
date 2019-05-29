package com.ms.entity;

public class Finance {
    private Long id;

    private String payName;

    private Double payAdvance;

    private Double payTotal;

    private Integer payState;

    public Finance(Long id, String payName, Double payAdvance, Double payTotal, Integer payState) {
        this.id = id;
        this.payName = payName;
        this.payAdvance = payAdvance;
        this.payTotal = payTotal;
        this.payState = payState;
    }

    public Finance() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public Double getPayAdvance() {
        return payAdvance;
    }

    public void setPayAdvance(Double payAdvance) {
        this.payAdvance = payAdvance;
    }

    public Double getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(Double payTotal) {
        this.payTotal = payTotal;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }
}