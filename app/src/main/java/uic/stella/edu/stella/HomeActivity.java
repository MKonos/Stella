
package uic.stella.edu.stella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static uic.stella.edu.stella.R.id.planetList;

// this is Bart's comment
public class HomeActivity extends AppCompatActivity {

    //controls
    ListView planetListView;

    //vars
    String planetSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Pick a Planet!");

        planetListView = (ListView) findViewById(R.id.planetList);

        String[] aryPlanet = getResources().getStringArray(R.array.planets);

        //populate listview
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aryPlanet);

        setTitle("Planet Select");

        //display populated list view
        planetListView.setAdapter(aryAdapter);

        planetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //planetSelected = planetListView.getItemAtPosition(position).toString();

                planetSelected = ((TextView) view).getText().toString();

                Toast.makeText(getApplicationContext(), planetSelected,
                        Toast.LENGTH_SHORT).show();

                //Intent i = new Intent(getActivity(), DisplayPlanet.class);
                //startActivity(i);
                //((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });


    }
}
