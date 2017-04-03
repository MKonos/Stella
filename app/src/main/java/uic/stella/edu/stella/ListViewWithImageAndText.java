
package uic.stella.edu.stella;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListViewWithImageAndText extends Fragment {


    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "Jupiter", "Mars", "Mercury", "Neptune",
            "Saturn", "Earth", "Uranus", "Venus",
    };


    int[] listviewImage = new int[]{
            R.drawable.jupiter, R.drawable.mars, R.drawable.mercury, R.drawable.neptune,
            R.drawable.saturn, R.drawable.earth, R.drawable.uranus, R.drawable.venus,
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


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listview_with_image_and_text, container, false);
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        ListView androidListView = (ListView) rootView.findViewById(R.id.list_view);
        androidListView.setAdapter(new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to));
        return rootView;
    }

}