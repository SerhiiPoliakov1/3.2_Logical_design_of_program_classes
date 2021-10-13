package com.clickonlinetochka.clickonlinetochka.model;

import org.bson.codecs.jsr310.LocalDateTimeCodec;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    @Indexed
    private Map<Product,Long> productsInOrder;
    private Double totalPrice;
    private Customer customer;
    private LocalDateTime createDateTime;
    private Status status;

    public  Order(){
        createDateTime = LocalDateTime.now();
        status = Status.NEW;
    }
    public Order(Map<Product,Long> productsInOrder, Double totalPrice, Customer customer, LocalDateTime createDateTime, Status status) {
        this.productsInOrder = productsInOrder;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.createDateTime = createDateTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Product,Long> getProductsInOrder() {
        return productsInOrder;
    }

    public void setProductsInOrder(Map<Product,Long> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(productsInOrder, order.productsInOrder) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(customer, order.customer) && Objects.equals(createDateTime, order.createDateTime) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productsInOrder, totalPrice, customer, createDateTime, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productsInOrder=" + productsInOrder +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", createDateTime=" + createDateTime +
                ", status=" + status +
                '}';
    }
}
