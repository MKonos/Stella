package uic.stella.edu.stella;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static uic.stella.edu.stella.AppSettings.APP_SETTINGS;


public class MoonDisplay extends AppCompatActivity {

    //public class ListViewWithImageAnd extends AppSettings {


    //private AppSettings app_settings;

    //controls
    GridView planetGridView;

    //vars
    String planetSelected;

    // Array of strings for ListView Title
    String[] gridviewTitle = new String[]{
            "Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune",
    };


    Integer[] gridviewImage = new Integer[]{
            R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupiter,
            R.drawable.saturn, R.drawable.uranus, R.drawable.neptune
    };

    String[] gridviewShortDescription = new String[]{
            "1", "2", "3", "4",
            "5", "6", "7", "8",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_display);

        setTitle("Moons");

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        planetGridView = (GridView) findViewById(R.id.moongrid);

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("grid_item_label", gridviewTitle[i]);
            //hm.put("gridview_discription", gridviewShortDescription[i]);
            hm.put("grid_item_image", Integer.toString(gridviewImage[i]));
            aList.add(hm);
        }

        //planetGridView.setAdapter(new ImageAdapter(this, gridviewTitle));

        String[] from = {"grid_item_image", "grid_item_label"};
        int[] to = {R.id.grid_item_image, R.id.grid_item_label};

        final GridView androidListView = (GridView) findViewById(R.id.moongrid);

        androidListView.setAdapter(new SimpleAdapter(this, aList, R.layout.activity_moon_display, from, to));


        planetGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                planetSelected = planetGridView.getItemAtPosition(position).toString();

                Intent myIntent = new Intent(view.getContext(), DisplayPlanet.class);
                myIntent.putExtra("thePlanet", planetSelected);
                startActivity(myIntent);
            }
        });
    }
}
