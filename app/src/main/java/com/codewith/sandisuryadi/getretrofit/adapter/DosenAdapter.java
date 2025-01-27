package com.codewith.sandisuryadi.getretrofit.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.codewith.sandisuryadi.getretrofit.R;
import com.codewith.sandisuryadi.getretrofit.model.SemuadosenItem;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.DosenHolder> {

    List<SemuadosenItem> semuadosenItemList;
    Context mContext;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public DosenAdapter(Context context, List<SemuadosenItem> dosenList){
        this.mContext = context;
        semuadosenItemList = dosenList;
    }

    @Override
    public DosenHolder onCreateViewHolder(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dosen, parent, false);
        return new DosenHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DosenHolder holder, int position) {
        final SemuadosenItem semuadosenItem = semuadosenItemList.get(position);
        holder.tvNamaDosen.setText(semuadosenItem.getNama());
        holder.tvNamaMatkul.setText(semuadosenItem.getMatkul());

        String namaDosen = semuadosenItem.getNama();
        String firstCharNamaDosen = namaDosen.substring(0,1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNamaDosen, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);

    }

    // Fungsi getColor untuk mengambil color random dari mColors untuk di set ke dalam imageview.
    private int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }

    @Override
    public int getItemCount() {
        return semuadosenItemList.size();
    }

    public class DosenHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivTextDrawable)
        ImageView ivTextDrawable;
        @BindView(R.id.tvNamaDosen)
        TextView tvNamaDosen;
        @BindView(R.id.tvNamaMatkul)
        TextView tvNamaMatkul;

        public DosenHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
