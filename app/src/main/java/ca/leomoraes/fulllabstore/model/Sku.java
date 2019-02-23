package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sku {

    @SerializedName("Id")
    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Order")
    private String order;

    @SerializedName("Sellers")
    private List<Seller> sellers = null;

    @SerializedName("Images")
    private List<Image> images = null;

    @SerializedName("Variations")
    private Variations variations;

    @SerializedName("SkuName")
    private String skuName;

    @SerializedName("UnitMultiplier")
    private Integer unitMultiplier;

    @SerializedName("ComplementName")
    private String complementName;

    @SerializedName("MeasurementUnit")
    private String measurementUnit;

    @SerializedName("EAN")
    private String eAN;

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Variations getVariations() {
        return variations;
    }

    public void setVariations(Variations variations) {
        this.variations = variations;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(Integer unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    public String getComplementName() {
        return complementName;
    }

    public void setComplementName(String complementName) {
        this.complementName = complementName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String geteAN() {
        return eAN;
    }

    public void seteAN(String eAN) {
        this.eAN = eAN;
    }
}
