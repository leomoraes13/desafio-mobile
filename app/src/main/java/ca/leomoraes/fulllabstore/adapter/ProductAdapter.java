package ca.leomoraes.fulllabstore.adapter;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.model.BestInstallment;
import ca.leomoraes.fulllabstore.model.Image;
import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.model.Seller;
import ca.leomoraes.fulllabstore.model.Sku;
import ca.leomoraes.fulllabstore.util.NumberUtil;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> products;

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_image) ImageView productImage;
        @BindView(R.id.product_title) TextView productTitle;
        @BindView(R.id.product_list_price) TextView productListPrice;
        @BindView(R.id.product_price) TextView productPrice;
        @BindView(R.id.product_payment) TextView productPayment;
        @BindView(R.id.product_discount) TextView productDiscount;
        @BindView(R.id.product_details) Button detailsButton;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Product product) {
            if(product.getSkus()!=null && !product.getSkus().isEmpty()) {
                Sku sku = product.getSkus().get(0);
                Seller seller = sku.getSellers().get(0);
                Image image = sku.getImages().get(0);
                BestInstallment payment = seller.getBestInstallment();

                productTitle.setText(product.getName());

                if(seller.getListPrice()>seller.getPrice()){
                    productListPrice.setText(NumberUtil.formatCurrency(seller.getListPrice()));
                    productListPrice.setPaintFlags(productListPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    productDiscount.setText(NumberUtil.formatPercentual(seller.getPrice(), seller.getListPrice()));
                }else{
                    productListPrice.setVisibility(View.INVISIBLE);
                    productDiscount.setVisibility(View.GONE);
                }
                productPrice.setText(NumberUtil.formatCurrency(seller.getPrice()));
                productPayment.setText(String.format(NumberUtil.locale,"%1$d x de %2$s", payment.getCount(), NumberUtil.formatCurrency(payment.getValue())) );

                String posterPath = image.getImageUrl();
                if (!TextUtils.isEmpty(posterPath)) {
                    Glide.with(itemView)
                            .load(posterPath)
                            .apply(new RequestOptions().placeholder(R.drawable.img_default))
                            .into(productImage);
                }
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (products == null) {
            return 0;
        }
        return products.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    /**
     * When data changes, this method updates the list of products
     * and notifies the adapter to use the new values on it
     */
    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
}
