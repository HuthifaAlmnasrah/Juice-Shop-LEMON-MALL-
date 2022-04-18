package com.example.lemomall.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lemomall.GreenFruitsActivity;
import com.example.lemomall.MainActivity;
import com.example.lemomall.Model.Item;
import com.example.lemomall.NewFruitsActivity;
import com.example.lemomall.R;
import com.example.lemomall.SummerFruotsActivity;
import com.example.lemomall.WinterFruitsActivity;

import java.util.List;

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder>{

    private List<Item> items;
    private ViewPager2 viewPager2;

    public SlideAdapter(List<Item> items, ViewPager2 viewPager2) {
        this.items = items;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
        holder.setInfo(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder{
        private TextView type;
        private ImageView image;
        private RelativeLayout layout;
        public SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            image = itemView.findViewById(R.id.img);
            layout = itemView.findViewById(R.id.relative);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(type.getText().equals("SUMMER FRUITS")){
                        ActivityCompat.startActivity(itemView.getContext(),new Intent(itemView.getContext(), SummerFruotsActivity.class), null);
                    }
                    if(type.getText().equals("NEW FRUITS")){
                        ActivityCompat.startActivity(itemView.getContext(),new Intent(itemView.getContext(), NewFruitsActivity.class), null);
                    }
                    if(type.getText().equals("WINTER FRUITS")){
                        ActivityCompat.startActivity(itemView.getContext(),new Intent(itemView.getContext(), WinterFruitsActivity.class), null);
                    }
                    if(type.getText().equals("GREEN FRUITS")){
                        ActivityCompat.startActivity(itemView.getContext(),new Intent(itemView.getContext(), GreenFruitsActivity.class), null);
                    }
                }
            });
        }
        void setInfo(Item info){
            type.setText(info.getType());
            image.setImageResource(info.getImg());
        }
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            items.addAll(items);
            notifyDataSetChanged();
        }
    };
}
