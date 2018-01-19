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
public class EntertainmentFragment extends Fragment {


    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.list_view,container,false);
        //Creating a new arrayList of Item objects
        final ArrayList<Item> item=new ArrayList<>();
        //Adding items into the ArrayList
        item.add(new Item(R.string.park_name,R.string.park_desc,R.drawable.park,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.imall_name,R.string.imall_desc,R.drawable.iulius_mall,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.pmall_name,R.string.pmall_desc,R.drawable.vivo,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.cetatuie_name,R.string.cetatuie_desc,R.drawable.cetatuie,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.dom_name,R.string.dom_desc,R.drawable.dom_regilor,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.ipark_name,R.string.ipark_desc,R.drawable.parc_iulius,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.piata_name,R.string.piata_desc,R.drawable.piata_unirii,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.bpark_name,R.string.bpark_desc,R.drawable.parcul_babes,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.wonder_name,R.string.wonder_desc,R.drawable.wonderland_out,R.drawable.ic_info_outline_black_24dp));
        //Creating an item Adapter
        ItemAdapter itemList = new ItemAdapter(getActivity(),item);
        //Getting the list from XML
        ListView listView=(ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemList);
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
