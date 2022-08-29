package com.example.demo.Data;

import org.springframework.stereotype.Component;

@Component
public class ApiResult {
    CustomerInfo customerInfo;
    String message;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
