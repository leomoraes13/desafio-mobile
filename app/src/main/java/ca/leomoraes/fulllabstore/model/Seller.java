package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

public class Seller {

    @SerializedName("Id")
    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Quantity")
    private Integer quantity;

    @SerializedName("Price")
    private Double price;

    @SerializedName("ListPrice")
    private Double listPrice;

    @SerializedName("BestInstallment")
    private BestInstallment bestInstallment;

    @SerializedName("Offer")
    private String offer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public BestInstallment getBestInstallment() {
        return bestInstallment;
    }

    public void setBestInstallment(BestInstallment bestInstallment) {
        this.bestInstallment = bestInstallment;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }
}
