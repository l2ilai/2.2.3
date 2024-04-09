package com.example._223.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {

    private Integer minimalIncome;

    private Integer priceCar;

    public Integer getMinimalIncome() {
        return minimalIncome;
    }

    public void setMinimalIncome(Integer minimalIncome) {
        this.minimalIncome = minimalIncome;
    }

    public Integer getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(Integer priceCar) {
        this.priceCar = priceCar;
    }
}
