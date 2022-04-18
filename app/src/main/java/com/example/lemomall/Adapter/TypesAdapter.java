package com.example.lemomall.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lemomall.R;

public class TypesAdapter extends BaseAdapter {

    private Context context;
    private String[] types;
    private LayoutInflater inflater;

    public TypesAdapter(Context context, String[] types) {
        this.context = context;
        this.types = types;
    }

    @Override
    public int getCount() {
        return types.length;
    }

    @Override
    public Object getItem(int i) {
        return types[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.type_item, null);
        }
        TextView textView = view.findViewById(R.id.type);
        textView.setText(types[i]);
        return view;
    }
}
