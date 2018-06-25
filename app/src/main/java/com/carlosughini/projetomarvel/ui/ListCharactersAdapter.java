package com.carlosughini.projetomarvel.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.carlosughini.projetomarvel.R;
import com.carlosughini.projetomarvel.models.CityListData;

import java.util.List;

public class ListCharactersAdapter extends RecyclerView.Adapter<ListCharactersAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<CityListData> data;
    private Context context;

    public ListCharactersAdapter(Context context, List<CityListData> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public ListCharactersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ListCharactersAdapter.ViewHolder holder, int position) {
//        holder.click(data.get(position), listener);
//        holder.tvCity.setText(data.get(position).getName());
//        holder.tvDesc.setText(data.get(position).getDescription());
//
//        String images = data.get(position).getBackground();
//
//        Glide.with(context)
//                .load(images)
//                .into(holder.background);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(CityListData Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView texto1, texto2;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            texto1 = itemView.findViewById(R.id.texto1);
            texto2 = itemView.findViewById(R.id.texto2);
            background = itemView.findViewById(R.id.image);

        }


        public void click(final CityListData cityListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }
    }


}