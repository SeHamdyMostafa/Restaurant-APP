package com.example.resturant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PurchasesAdapter extends BaseAdapter {
    Context c;
    ArrayList<String> FoodNames=new ArrayList<>();
    ArrayList<String> FoodPrice=new ArrayList<>();
    ArrayList<Integer> FoodImage=new ArrayList<>();
    LayoutInflater inflater;

    PurchasesAdapter(Context c, ArrayList<String> FoodNames, ArrayList<String> FoodPrices, ArrayList<Integer> FoodImages){
        this.c=c;
        this.FoodNames=FoodNames;
        this.FoodPrice=FoodPrices;
        this.FoodImage=FoodImages;

        inflater =LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return FoodNames.size();
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
        convertView=inflater.inflate(R.layout.activity_cart_model,null);
        TextView foodprice=convertView.findViewById(R.id.tv_fooPrice_cart);
        TextView foodName=convertView.findViewById(R.id.tv_foodName_cart);
        ImageView foodImage=convertView.findViewById(R.id.image_foodImage_cart);
        foodName.setText(FoodNames.get(position));
        foodprice.setText(FoodPrice.get(position));
        foodImage.setImageResource(FoodImage.get(position));
        return convertView;

    }
}
