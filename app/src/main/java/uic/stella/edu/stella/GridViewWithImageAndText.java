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


public class GridViewWithImageAndText extends Fragment {

    //public class ListViewWithImageAnd extends AppSettings {


    //private AppSettings app_settings;

    //controls
    GridView planetListView;

    //vars
    String planetSelected;

    // Array of strings for ListView Title
    public String[] gridviewTitle = new String[]{
            "Earth", "Jupiter",  "Mars","Mercury", "Neptune","Saturn", "Uranus","Venus"
    };


    Integer[] gridviewImage = new Integer[]{
            R.drawable.earth, R.drawable.jupiter, R.drawable.mars, R.drawable.mercury, R.drawable.neptune,
            R.drawable.saturn, R.drawable.uranus, R.drawable.venus
    };

    String[] gridviewShortDescription = new String[]{
            "1", "2", "3", "4",
            "5", "6", "7", "8",
    };

    private View fragmentView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_gridview_with_image_and_text, container, false);
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        fragmentView = inflater.inflate(R.layout.activity_gridview_with_image_and_text, container, false);

        planetListView = (GridView) fragmentView.findViewById(R.id.customgrid);

        for (int i = 0; i < 8; i++) {
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