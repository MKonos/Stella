package uic.stella.edu.stella;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static uic.stella.edu.stella.AppSettings.APP_SETTINGS;
import static android.R.id.message;
import static uic.stella.edu.stella.AppSettings.current_planet;


public class ListViewWithImageAndText extends Fragment {

    //public class ListViewWithImageAnd extends AppSettings {


        //private AppSettings app_settings;

        //controls
        ListView planetListView;

        //vars
        String planetSelected;

        // Array of strings for ListView Title
        String[] listviewTitle = new String[]{
                "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune",
        };


        int[] listviewImage = new int[]{
                R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupiter,
                R.drawable.saturn, R.drawable.uranus, R.drawable.neptune
        };

        String[] listviewShortDescription = new String[]{
                "", "", "", "",
                "", "", "", "",
        };

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_with_image_and_text);

        /*List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

       /* String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        /*SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) androidListView.findViewById();
        androidListView.setAdapter(simpleAdapter);
    }*/

        //SharedPreferences spAppSettings;

    private View fragmentView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_listview_with_image_and_text, container, false);
            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();


            //app_settings = new AppSettings();
            //super.onCreate(savedInstanceState);
            fragmentView = inflater.inflate(R.layout.activity_listview_with_image_and_text, container, false);

            //spAppSettings = app_settings.getSharedPreferences(app_settings.current_planet, Context.MODE_PRIVATE);
            //final SharedPreferences.Editor editor = (spAppSettings.edit());


            planetListView = (ListView) fragmentView.findViewById(R.id.list_view);

            for (int i = 0; i < 8; i++) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", listviewTitle[i]);
                hm.put("listview_discription", listviewShortDescription[i]);
                hm.put("listview_image", Integer.toString(listviewImage[i]));
                aList.add(hm);
            }

            //CHANGE THE APP_SETTINGS VALUE
            //editor.putString(APP_SETTINGS_NUMBER, intNumber.toString());
            //editor.commit();

            String[] from = {"listview_image", "listview_title", "listview_discription"};
            int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

            final ListView androidListView = (ListView) rootView.findViewById(R.id.list_view);
            androidListView.setAdapter(new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to));

        //planetListView.setAdapter(androidListView);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //planetSelected = planetListView.getItemAtPosition(position).toString();

                //planetSelected = ((ListView) view).toString();

                //LinearLayout ll = (LinearLayout) view;
                //ListView tv = (ListView) view.findViewById(R.id.list_view);
                planetSelected = androidListView.getItemAtPosition(position).toString();

                //Toast.makeText(getActivity(), planetSelected,
                        //Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(view.getContext(), DisplayPlanet.class);
                myIntent.putExtra("thePlanet", planetSelected);
                startActivity(myIntent);
            }
        });
            return rootView;
        }
    //}

}