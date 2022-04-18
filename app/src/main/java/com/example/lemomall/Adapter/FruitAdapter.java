package com.example.lemomall.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lemomall.Model.FruitItem;
import com.example.lemomall.R;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.AdapterHolder>{

    List<FruitItem> items;
    Context context;

    public FruitAdapter(List<FruitItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterHolder(
          LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        holder.setInfo(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class AdapterHolder extends RecyclerView.ViewHolder {

        ImageView img, remove, add;
        TextView name, price;

        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            add = itemView.findViewById(R.id.add);
            remove = itemView.findViewById(R.id.remove);
        }
        void setInfo(FruitItem info){
            img.setImageResource(info.getImg());
            name.setText(info.getName());
            price.setText(info.getPrice()+"");

            final double[] total = {0};
            double itemPrice = Double.parseDouble(price.getText().toString());
            final int[] count = {0};

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(total[0] > itemPrice){
                        total[0] = total[0] - itemPrice;
                        price.setText(total[0] +"");
                        count[0]--;
                    }
                }
            });
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    total[0] = total[0] + itemPrice;
                    price.setText(total[0] +"");
                    count[0]++;
                }
            });
        }
    }
}
