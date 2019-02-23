package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

public class ProductRequest {

    @SerializedName("Query")
    private String query;

    @SerializedName("Size")
    private Integer size;

    @SerializedName("Offset")
    private Integer Offset;

    public ProductRequest() {
    }

    public ProductRequest(String query, Integer size, Integer offset) {
        this.query = query;
        this.size = size;
        Offset = offset;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOffset() {
        return Offset;
    }

    public void setOffset(Integer offset) {
        Offset = offset;
    }
}
