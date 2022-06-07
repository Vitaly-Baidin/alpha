package com.viskei.alpha.model;

import java.util.Map;
import java.util.Objects;

public class Exchange {
    private String disclaimer;
    private String license;
    private String base;
    private Map<String, Double> rates;

    public Exchange() {
    }

    public Exchange(String disclaimer, String license, String base, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.base = base;
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchange exchange = (Exchange) o;

        return Objects.equals(disclaimer, exchange.disclaimer) && Objects.equals(license, exchange.license) && Objects.equals(base, exchange.base) && Objects.equals(rates, exchange.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disclaimer, license, base, rates);
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "disclaimer='" + disclaimer + '\'' +
                ", license='" + license + '\'' +
                ", base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
