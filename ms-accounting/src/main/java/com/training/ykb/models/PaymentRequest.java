package com.training.ykb.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PaymentRequest {

    @NotNull
    @Positive
    private Long    orderId;
    @NotNull
    @Max(1000)
    @Positive
    private Integer amount;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amountParam) {
        this.amount = amountParam;
    }


    @Override
    public String toString() {
        return "PaymentRequest [orderId=" + this.orderId + ", amount=" + this.amount + "]";
    }


}
