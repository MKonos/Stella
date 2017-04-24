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

        planetGridView = (GridView) findViewById(R.id.gridView1);

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("gridview_title", gridviewTitle[i]);
            hm.put("gridview_discription", gridviewShortDescription[i]);
            hm.put("gridview_image", Integer.toString(gridviewImage[i]));
            aList.add(hm);
        }

        planetGridView.setAdapter(new ImageAdapter(this, gridviewImage));

        //String[] from = {"gridview_image", "gridview_title", "gridview_discription"};
        //int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        //final GridView androidGridView = (GridView) findViewById(R.id.moongrid);

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

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;

    public ImageAdapter(Context context, String[] mobileValues) {
        this.context = context;
        this.mobileValues = mobileValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.mobile, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(mobileValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String mobile = mobileValues[position];

            if (mobile.equals("Windows")) {
                imageView.setImageResource(R.drawable.windows_logo);
            } else if (mobile.equals("iOS")) {
                imageView.setImageResource(R.drawable.ios_logo);
            } else if (mobile.equals("Blackberry")) {
                imageView.setImageResource(R.drawable.blackberry_logo);
            } else {
                imageView.setImageResource(R.drawable.android_logo);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}