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
        String[] gridviewTitle = new String[]{
                "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune",
        };


        int[] gridviewImage = new int[]{
                R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupiter,
                R.drawable.saturn, R.drawable.uranus, R.drawable.neptune
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

        fragmentView = inflater.inflate(R.layout.activity_listview_with_image_and_text, container, false);

        planetListView = (GridView) fragmentView.findViewById(R.id.customgrid);

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", gridviewTitle[i]);
            hm.put("listview_discription", gridviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(gridviewImage[i]));
            aList.add(hm);


            String[] from = {"listview_image", "listview_title", "listview_discription"};
            int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

            final GridView androidListView = (GridView) rootView.findViewById(R.id.customgrid);
            androidListView.setAdapter(new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to));


            androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    planetSelected = androidListView.getItemAtPosition(position).toString();

                    Intent myIntent = new Intent(view.getContext(), DisplayPlanet.class);
                    myIntent.putExtra("thePlanet", planetSelected);
                    startActivity(myIntent);
                }
            });
            //return rootView;
        }
        //}

        return rootView;
    }
}