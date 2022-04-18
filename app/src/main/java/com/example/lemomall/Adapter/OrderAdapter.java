package com.example.lemomall.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lemomall.Model.Order;
import com.example.lemomall.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.AdapterHolder>{

    List<Order> orders;
    Context context;

    public OrderAdapter(List<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterHolder(
                LayoutInflater.from(context).inflate(R.layout.order_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        holder.setInfo(orders.get(position));
    }
    @Override
    public int getItemCount() {
        return orders.size();
    }

    class AdapterHolder extends RecyclerView.ViewHolder {
        TextView orderId, total;
        ImageView delete;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.name);
            total = itemView.findViewById(R.id.total);
            delete =itemView.findViewById(R.id.delete);
        }
        void setInfo(Order info){
            orderId.setText(info.getOderId());
            total.setText(info.getPrice()+" JD");
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    orders.remove(getAdapterPosition());
                    notifyItemChanged(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
