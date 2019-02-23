package ca.leomoraes.fulllabstore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Variations {
    @SerializedName("Voltagem")
    private List<String> voltagem = null;

    @SerializedName("Cor")
    private List<String> cor = null;

    public List<String> getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(List<String> voltagem) {
        this.voltagem = voltagem;
    }

    public List<String> getCor() {
        return cor;
    }

    public void setCor(List<String> cor) {
        this.cor = cor;
    }
}