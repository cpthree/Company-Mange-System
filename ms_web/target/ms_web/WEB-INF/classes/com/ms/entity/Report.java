package com.ms.entity;

import com.ms.utils.ExcelDesc;

public class Report {
    private Long id;

    @ExcelDesc(value = "项目名" , orderBy = "1")
    private String reportName;

    @ExcelDesc(value = "成本" , orderBy = "2")
    private Double cost;

    @ExcelDesc(value = "营业额" , orderBy = "3")
    private Double price;

    @ExcelDesc(value = "利润" , orderBy = "4")
    private Double profit;

    @ExcelDesc(value = "税后盈利" , orderBy = "5")
    private Double taxProfit;

    public Report(Long id, String reportName, Double cost, Double price, Double profit, Double taxProfit) {
        this.id = id;
        this.reportName = reportName;
        this.cost = cost;
        this.price = price;
        this.profit = profit;
        this.taxProfit = taxProfit;
    }

    public Report() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getTaxProfit() {
        return taxProfit;
    }

    public void setTaxProfit(Double taxProfit) {
        this.taxProfit = taxProfit;
    }
}