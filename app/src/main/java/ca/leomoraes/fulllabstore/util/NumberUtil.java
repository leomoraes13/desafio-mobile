package ca.leomoraes.fulllabstore.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtil {

    public static Locale locale = new Locale("pt", "BR");
    private static final String VAZIO = "-";

    public static String formatPercentual(Double price, Double lastPrice){
        double percent = ((lastPrice - price) / lastPrice) * 100;
        return Math.round(percent)+"%";
    }

    public static String formatNumber(Double num){
        if(num==null)
            return VAZIO;

        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        return numberFormat.format(num);
    }

    public static String formatCurrency(Double num){
        if(num==null)
            return VAZIO;

        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(num).trim();
    }
}
