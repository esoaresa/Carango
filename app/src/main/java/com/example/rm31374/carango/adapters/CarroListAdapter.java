package com.example.rm31374.carango.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rm31374.carango.R;
import com.example.rm31374.carango.listener.OnClickListener;
import com.example.rm31374.carango.model.Carro;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rm31374 on 19/11/2016.
 */
public class CarroListAdapter extends RecyclerView.Adapter<CarroListAdapter.CarrosViewHolder> {

    private Context context;
    private List<Carro> carros;
    private OnClickListener clickListener;

    public CarroListAdapter(Context context, List<Carro> carros, OnClickListener clickListener) {
        this.context = context;
        this.carros = carros;
        this.clickListener = clickListener;
    }

    public CarroListAdapter(Context context, List<Carro> body) {
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.carro_row, parent, false);
        return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CarrosViewHolder holder, final int position) {
        holder.tvNome.setText(carros.get(position).getNome());
        holder.tvDescricao.setText(carros.get(position).getDescricao());
        Picasso.with(context).load(carros.get(position).getFoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivCarro);

        if (clickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onClick(holder.itemView, position);
                }
            });
        }
    }

    public Carro getItem(int position) {
        return carros.get(position);
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNome;
        TextView tvDescricao;
        ImageView ivCarro;

        public CarrosViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            ivCarro = (ImageView) itemView.findViewById(R.id.ivCarro);

        }
    }
}
