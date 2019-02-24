package ca.leomoraes.fulllabstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Category> parentChildData;
    Context ctx;

    public CategoryAdapter(Context ctx, List<Category> parentChildData) {
        this.ctx = ctx;
        this.parentChildData = parentChildData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.category_recycler)
        RecyclerView rv_child;

        @BindView(R.id.category_titulo)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        CategoryAdapter.ViewHolder pavh = new CategoryAdapter.ViewHolder(itemLayoutView);
        return pavh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Category category = parentChildData.get(position);
        // initChildLayoutManager(vh.rv_child, category.getPerguntas());

        vh.title.setText(category.getName());

        vh.itemView.setOnClickListener(v -> {
            if(vh.rv_child.getVisibility()==View.VISIBLE){
                vh.rv_child.setVisibility(View.GONE);
            }else{
                vh.rv_child.setVisibility(View.VISIBLE);
            }
        });

    }

/*    private void initChildLayoutManager(RecyclerView rv_child, List<PerguntasDuvidas> childData) {
        rv_child.setLayoutManager(new NestedRecyclerLinearLayoutManager(ctx));
        CategoryChildAdapter childAdapter = new CategoryChildAdapter(childData);
        rv_child.setAdapter(childAdapter);
    }*/

    @Override
    public int getItemCount() {
        return parentChildData.size();
    }
}