package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

public class SubCategory {
    @SerializedName("Id")
    private Integer id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Image")
    private String image;

    @SerializedName("Highlight")
    private Boolean highlight;

    @SerializedName("Icon")
    private String icon;

    @SerializedName("CategoryListOrder")
    private Integer categoryListOrder;

    @SerializedName("CategoryTreeOrder")
    private Integer categoryTreeOrder;

    @SerializedName("LinkId")
    private Integer linkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCategoryListOrder() {
        return categoryListOrder;
    }

    public void setCategoryListOrder(Integer categoryListOrder) {
        this.categoryListOrder = categoryListOrder;
    }

    public Integer getCategoryTreeOrder() {
        return categoryTreeOrder;
    }

    public void setCategoryTreeOrder(Integer categoryTreeOrder) {
        this.categoryTreeOrder = categoryTreeOrder;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }
}
