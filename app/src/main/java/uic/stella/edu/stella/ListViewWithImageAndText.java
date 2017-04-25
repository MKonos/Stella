package uic.stella.edu.stella;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static uic.stella.edu.stella.AppSettings.APP_SETTINGS;


public class ListViewWithImageAndText extends Fragment {

    //public class ListViewWithImageAnd extends AppSettings {


    //private AppSettings app_settings;

    //controls
    GridView planetGridView;

    //vars
    String planetSelected;

    // Array of strings for ListView Title
    String[] gridviewTitle = new String[]{
            "Ariel", "Dione", "Hyperion", "Iapetus",
            "Luna", "Miranda", "Oberon", "Rhea",
            "Tethys","Titan","Titania","Triton","Umbriel",
    };

    int[] gridviewImage = new int[]{
            R.drawable.ariel, R.drawable.dione, R.drawable.hyperion, R.drawable.iapetus, R.drawable.luna,
            R.drawable.miranda, R.drawable.oberon, R.drawable.rhea, R.drawable.tethys, R.drawable.titan
            , R.drawable.titania, R.drawable.triton , R.drawable.umbriel
    };

    String[] gridviewShortDescription = new String[]{
            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12", "13",
    };

    private View fragmentView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_gridview_with_image_and_text, container, false);
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        fragmentView = inflater.inflate(R.layout.activity_gridview_with_image_and_text, container, false);

        planetGridView = (GridView) fragmentView.findViewById(R.id.customgrid);

        for (int i = 0; i < 13; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("grid_item_label", gridviewTitle[i]);
            hm.put("grid_item_image", Integer.toString(gridviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"grid_item_image", "grid_item_label"};
        int[] to = {R.id.grid_item_image, R.id.grid_item_label};

        final GridView androidListView = (GridView) rootView.findViewById(R.id.customgrid);
        androidListView.setAdapter(new SimpleAdapter(getActivity(), aList, R.layout.grid_item, from, to));

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                planetSelected = androidListView.getItemAtPosition(position).toString();

                Intent myIntent = new Intent(view.getContext(), DisplayPlanet.class);
                myIntent.putExtra("thePlanet", planetSelected);
                startActivity(myIntent);
            }
        });
        return rootView;
    }
    //}

}