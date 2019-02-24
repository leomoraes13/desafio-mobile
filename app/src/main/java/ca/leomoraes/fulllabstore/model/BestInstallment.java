package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

public class BestInstallment {

    @SerializedName("Count")
    private Integer count;

    @SerializedName("Value")
    private Double value;

    @SerializedName("Total")
    private Double total;

    @SerializedName("Rate")
    private Integer rate;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
