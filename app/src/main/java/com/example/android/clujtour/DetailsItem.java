package com.example.android.clujtour;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_items);
        TextView desc=(TextView) findViewById(R.id.details_text);
        ImageView image=(ImageView)findViewById(R.id.details_image);
        TextView name=(TextView)findViewById(R.id.details_name);
        // Receiving the intent extras that were put in the fragments
        final Bundle extras=getIntent().getExtras();
        // Getting the Views from xml
        name.setText(extras.getString("name"));
        desc.setText(extras.getString("desc"));
        image.setImageResource(extras.getInt("image"));
        /*  Get the ImageView id from xml
        *   setOnClickListener for image
        *   using an Intent to open google maps at the address of the item name*/
        ImageView getLocation=(ImageView)findViewById(R.id.map_fragment);
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address=extras.getString("name");
                Uri mapUri=Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent= new Intent(Intent.ACTION_VIEW,mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
