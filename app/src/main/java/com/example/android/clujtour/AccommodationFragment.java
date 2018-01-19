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
public class AccommodationFragment extends Fragment {


    public AccommodationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.list_view,container,false);
        // Creating array of Item Objects
        final ArrayList<Item> item= new ArrayList<>();
        // Adding items in the array
        item.add(new Item(R.string.belvedere_name,R.string.belvedere_desc,R.drawable.belvedere,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.napoca_name,R.string.napoca_desc,R.drawable.napoca,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.transi_name,R.string.transi_desc,R.drawable.transilvania,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.melody_name,R.string.melody_desc,R.drawable.melody,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.paradis_name,R.string.paradis_desc,R.drawable.paradis,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.stil_name,R.string.stil_desc,R.drawable.stil,R.drawable.ic_info_outline_black_24dp));
        item.add(new Item(R.string.premier_name,R.string.premier_desc,R.drawable.premier,R.drawable.ic_info_outline_black_24dp));
        ItemAdapter itemAdapter=new ItemAdapter(getActivity(),item);
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
                Intent intent=new Intent(getActivity(),LocationActivity.class);
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
