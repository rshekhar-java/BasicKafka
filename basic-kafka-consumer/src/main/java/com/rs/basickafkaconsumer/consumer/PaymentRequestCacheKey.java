package com.rs.basickafkaconsumer.consumer;

import java.util.*;

/**
 * created by rs 5/2/2022.
 */
public class PaymentRequestCacheKey {
    private String paymentNumber;
    private int amount;
    private String transactionType;

    public PaymentRequestCacheKey(String paymentNumber, int amount, String transactionType) {
        super();
        this.paymentNumber = paymentNumber;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PaymentRequestCacheKey other = (PaymentRequestCacheKey) obj;
        return amount == other.amount && Objects.equals(paymentNumber, other.paymentNumber)
                && Objects.equals(transactionType, other.transactionType);
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentNumber, transactionType);
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "PaymentRequestCacheKey{" +
                "paymentNumber='" + paymentNumber + '\'' +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
