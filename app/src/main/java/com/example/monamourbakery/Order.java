package com.example.monamourbakery;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private static final Double DELIVERY_PRICE=30.0;

    private int orderID;
    private ArrayList<Product> products = new ArrayList<>();
    private Status eStatus;
    private String date;
    private Double totalPrice = 0.0;
    private String userEmail;

    public Order(){ }

    public Order(int orderID, ArrayList<Product> products, Status eStatus, Boolean shipping, String date, Double totalPrice,String userEmail) {
        this.orderID = orderID;
        this.products = products;
        this.eStatus = eStatus;
        this.date = date;
        this.userEmail = userEmail;
        this.totalPrice = totalPrice;
    }

    public static Double getDeliveryPrice() {
        return DELIVERY_PRICE;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        this.products.add(product);
        this.totalPrice += product.getPrice();
    }
    public void removeProduct(int position){
        double price = this.products.get(position).getPrice();
        this.products.remove(position);
        this.totalPrice -= price;
    }

    public Status geteStatus() {
        return eStatus;
    }

    public void seteStatus(Status eStatus) {
        this.eStatus = eStatus;
    }

    public void changeStatus(){
        if(this.eStatus== Status.WAITING)
            seteStatus(Status.ACCEPTED);
        else
            seteStatus(Status.WAITING);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }



    public String  getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String printProducts(){
        String productString = "";
        for (int i = 0; i < products.size(); i++) {
            productString += products.get(i).getPastry_name()+"\n";
        }
        return productString;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", products=" + products.size() +
                ", eStatus=" + eStatus +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
