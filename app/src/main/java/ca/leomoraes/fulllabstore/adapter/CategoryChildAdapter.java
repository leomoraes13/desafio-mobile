package ca.leomoraes.fulllabstore.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.model.SubCategory;

public class CategoryChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SubCategory> childData;

    public CategoryChildAdapter(List<SubCategory> childData) {
        this.childData = childData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.subcategory_titulo)
        TextView subCategoryText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subcategory, parent, false);

        CategoryChildAdapter.ViewHolder cavh = new CategoryChildAdapter.ViewHolder(itemLayoutView);
        return cavh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder vh = (ViewHolder) holder;

        SubCategory c = childData.get(position);
        vh.subCategoryText.setText( c.getName() );
    }

    @Override
    public int getItemCount() {
        return childData.size();
    }
}