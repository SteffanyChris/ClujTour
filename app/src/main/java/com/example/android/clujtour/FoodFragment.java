package com.example.android.clujtour;


import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.list_view,container,false);
        //Creating an ArrayList of Item
        final ArrayList<Item> item=new ArrayList<>();
        // Adding items in the array
        item.add(new Item(R.string.klausen_name,R.string.klausen_desc,R.drawable.klausen,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.nobori_name,R.string.nobori_desc,R.drawable.nobori,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.shanghai_name,R.string.shanghai_desc,R.drawable.shanghai,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.rex_name,R.string.rex_desc,R.drawable.rex,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.viena_name,R.string.viena_desc,R.drawable.bistro_viena,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.livada_name,R.string.livada_desc,R.drawable.livada,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.aroma_name,R.string.aroma_desc,R.drawable.aroma,R.drawable.ic_info_outline_black_24dp));
        ItemAdapter itemAdapter = new ItemAdapter(getActivity(), item);
        ListView listView=(ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
        /*  setOnItemClickListener for the items in the list
        *   currentItem is the item we click
        *   intent from this context to LocationActivity.class
        *   putExtra for getting the Name, Description Strings and ImageId of the current Object to pass them in
        *   LocationActivity */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item currentItem=item.get(position);
                Intent intent=new Intent(getActivity(),LocationActivity.class);
                intent.putExtra("desc",getString(currentItem.getmDescription()));
                intent.putExtra("image",currentItem.getmImageId());
                intent.putExtra("name",getString(currentItem.getmName()));
                startActivity(intent);
            }
        });
        return rootView;
    }

}
