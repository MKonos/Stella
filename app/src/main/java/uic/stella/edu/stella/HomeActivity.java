package uic.stella.edu.stella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static uic.stella.edu.stella.R.id.planetList;

// this is Bart's comment
public class HomeActivity extends AppCompatActivity {

    //controls
    ListView planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Pick a Planet!");

        planetList = (ListView) findViewById(R.id.planetList);

        String[] aryPlanet = getResources().getStringArray(R.array.planets);

        //populate listview
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aryPlanet);

        setTitle("Planet Select");

        //display populated list view
        planetList.setAdapter(aryAdapter);
    }
}
