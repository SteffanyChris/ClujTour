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
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.list_view,container,false);
        //Creating a new arrayList of Item objects
        final ArrayList<Item> item=new ArrayList<>();
        // Adding items in the array
        item.add(new Item(R.string.botanicm_name,R.string.botanicm_desc,R.drawable.muz_bot_ubb,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.botanical_garden_name,R.string.botanical_garden_desc,R.drawable.gradina_bot,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.historynm_name,R.string.historynm_desc,R.drawable.muz_history,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.parc_etno_name,R.string.parc_etno_desc,R.drawable.muz_nat_etno,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.forest_name,R.string.forest_desc,R.drawable.hoia,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.museums_name,R.string.museums_desc,R.drawable.muz_square,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.salina_name,R.string.salina_desc,R.drawable.salina,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.farma_name,R.string.farma_desc,R.drawable.muz_farma,R.drawable.ic_info_outline_black_24dp));
        ItemAdapter itemAdapter=new ItemAdapter(getActivity(),item);
        ListView listView=(ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
        /*  setOnItemClickListener for the items in the list
        *   currentItem is the item we click
        *   intent from this context to DetailsItem.class
        *   putExtra for getting the Name, Description Strings and ImageId of the current Object to pass them in
        *   DetailsItem.class */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DetailsItem.class);
                Item currentItem=item.get(position);
                intent.putExtra("image",currentItem.getmImageId());
                intent.putExtra("desc",getString(currentItem.getmDescription()));
                intent.putExtra("name",getString(currentItem.getmName()));
                startActivity(intent);
            }
        });
        return rootView;
    }

}
