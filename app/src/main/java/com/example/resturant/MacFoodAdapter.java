package com.example.resturant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MacFoodAdapter extends BaseAdapter {
    Context c;
    ArrayList<String> macFoodNames=new ArrayList<>();
    ArrayList<Integer> macFoodImages=new ArrayList<>();
    LayoutInflater inflater;

    MacFoodAdapter(Context c,ArrayList<String> macFoodNames, ArrayList<Integer> macFoodimages){
        this.c=c;
        this.macFoodNames=macFoodNames;
        this.macFoodImages=macFoodimages;
        inflater =LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return macFoodNames.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.food_item,null);
        ImageView foodImage=convertView.findViewById(R.id.image_foodImage);
        TextView foodName=convertView.findViewById(R.id.tv_foodName);
        foodImage.setImageResource(macFoodImages.get(position));
        foodName.setText(macFoodNames.get(position));
        return convertView;
    }
}
