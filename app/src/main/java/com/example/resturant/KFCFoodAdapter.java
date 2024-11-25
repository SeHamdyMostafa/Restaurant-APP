package com.example.resturant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KFCFoodAdapter extends BaseAdapter {

    Context c;
    ArrayList<String> kfcNames=new ArrayList<>();
    ArrayList<Integer> kfcImages=new ArrayList<>();
    LayoutInflater inflater;

    KFCFoodAdapter(Context c,ArrayList<String> kfcNames, ArrayList<Integer> kfcimages){
        this.c=c;
        this.kfcNames=kfcNames;
        this.kfcImages=kfcimages;
        inflater =LayoutInflater.from(c);
    }


    @Override
    public int getCount() {
        return kfcNames.size();

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
        foodImage.setImageResource(kfcImages.get(position));
        foodName.setText(kfcNames.get(position));
        return convertView;
}
}
