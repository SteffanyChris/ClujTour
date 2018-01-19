package com.example.android.clujtour;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 1/16/18.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    /**
     * Own constructor
     *
     * @param context the current context used to inflate layout
     * @param items   a list of Item objects to be displayed in the list
     */
    public ItemAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_in_list, parent, false);
        }
        Item currentItem=getItem(position);
        // Get the views from XML files
        ImageView image_one=(ImageView) listItemView.findViewById(R.id.item_image);
        TextView name_tv=(TextView) listItemView.findViewById(R.id.item_name);
        TextView desc_tv=(TextView) listItemView.findViewById(R.id.item_description);
        ImageView image_two=(ImageView) listItemView.findViewById(R.id.more_info);
        // set the current view to the item
        name_tv.setText(currentItem.getmName());
        desc_tv.setText(currentItem.getmDescription());
        if(currentItem.hasImage()){
            image_one.setImageResource(currentItem.getmImageId());
            image_one.setVisibility(View.VISIBLE);
        }else{
            image_one.setVisibility(View.GONE);
        }
        image_two.setImageResource(currentItem.getmInfoImgId());
        return listItemView;
    }
}