package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("ImageUrl")
    private String imageUrl;

    @SerializedName("ImageTag")
    private String imageTag;

    @SerializedName("Label")
    private String label;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
