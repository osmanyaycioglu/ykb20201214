package com.training.ykb.order.models;


public class PaymentRequest {

    private long orderId;
    private int  amount;

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(final int amountParam) {
        this.amount = amountParam;
    }

    @Override
    public String toString() {
        return "PaymentRequest [orderId=" + this.orderId + ", amount=" + this.amount + "]";
    }


}
