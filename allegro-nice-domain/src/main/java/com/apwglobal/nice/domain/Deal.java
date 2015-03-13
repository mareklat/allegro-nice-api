package com.apwglobal.nice.domain;

import com.apwglobal.nice.util.UnixDate;

import java.util.Date;

public class Deal {

    protected long eventId;
    protected DealType dealType;
    protected Date eventTime;
    protected long id;
    protected long transactionId;
    protected int sellerId;
    protected long itemId;
    protected int buyerId;
    protected int quantity;

    public Deal() { }

    private Deal(Builder builder) {
        eventId = builder.eventId;
        dealType = builder.dealType;
        eventTime = builder.eventTime;
        id = builder.id;
        transactionId = builder.transactionId;
        sellerId = builder.sellerId;
        itemId = builder.itemId;
        buyerId = builder.buyerId;
        quantity = builder.quantity;
    }


    public long getEventId() {
        return eventId;
    }
    public DealType getDealType() {
        return dealType;
    }
    public Date getEventTime() {
        return eventTime;
    }
    public long getId() {
        return id;
    }
    public long getTransactionId() {
        return transactionId;
    }
    public int getSellerId() {
        return sellerId;
    }
    public long getItemId() {
        return itemId;
    }
    public int getBuyerId() {
        return buyerId;
    }
    public int getQuantity() {
        return quantity;
    }

    public static final class Builder {
        private long eventId;
        private DealType dealType;
        private Date eventTime;
        private long id;
        private long transactionId;
        private int sellerId;
        private long itemId;
        private int buyerId;
        private int quantity;

        public Builder() {
        }

        public Builder eventId(long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder dealType(int dealType) {
            this.dealType = DealType.VALUES.get(dealType);
            return this;
        }

        public Builder eventTime(long eventTime) {
            this.eventTime = UnixDate.toDate(eventTime);
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder transactionId(long transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder sellerId(int sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder itemId(long itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder buyerId(int buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Deal build() {
            return new Deal(this);
        }
    }

    @Override
    public String toString() {
        return "Deal{" +
                "eventId=" + eventId +
                ", dealType=" + dealType +
                ", eventTime=" + eventTime +
                ", id=" + id +
                ", transactionId=" + transactionId +
                ", itemId=" + itemId +
                ", buyerId=" + buyerId +
                ", quantity=" + quantity +
                '}';
    }
}
