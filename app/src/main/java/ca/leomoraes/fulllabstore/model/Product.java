package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("Availability")
    private Boolean availability;

    @SerializedName("Skus")
    private List<Sku> skus = null;

    @SerializedName("Name")
    private String name;

    @SerializedName("Id")
    private String id;

    @SerializedName("Brand")
    private String brand;

    @SerializedName("Description")
    private String description;

    @SerializedName("Category")
    private String category;

    @SerializedName("Categories")
    private List<String> categories = null;

    @SerializedName("Variations")
    private List<String> variations = null;

    @SerializedName("Videos")
    private List<String> videos = null;

    @SerializedName("Images")
    private String images;

    @SerializedName("RealId")
    private String realId;

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId;
    }
}
