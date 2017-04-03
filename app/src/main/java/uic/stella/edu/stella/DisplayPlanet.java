package uic.stella.edu.stella;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class DisplayPlanet extends AppSettings{

// the text fields that we will fill
    TextView PlanetName;
    TextView EquatorialDiameter;
    TextView Mass;
    TextView Moons;
    TextView OrbitDistance;
    TextView OrbitPeriod;
    TextView EffectiveTemperature;
    TextView DiscoveryDate;
    TextView DiscoveredBy;
    ImageView planetPicture;

    SharedPreferences spAppSettings;

    int[] listviewImage;
    String myPlanet;
    String[] by;
    String[] date;
    String[] temp;
    String[] period;
    String[] distance;
    String[] moons;
    String[] mass;
    String[] diameter;
    String[] planetNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_info);

        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        Bundle bundle = getIntent().getExtras();
        myPlanet = bundle.getString("thePlanet");

        setTitle("*SELECTED PLANET*");

      //  Toast.makeText(this, message,
            //    Toast.LENGTH_SHORT).show();

       // final SharedPreferences.Editor editor = (spAppSettings.edit()); // incase we need to change values

       //myPlanet = spAppSettings.getString(current_planet, "");


        listviewImage = new int[]{
                R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars,
                R.drawable.jupiter, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune,
        };


        planetNames = getResources().getStringArray(R.array.planets);
        diameter = getResources().getStringArray(R.array.diameter);
        mass = getResources().getStringArray(R.array.mass);
        moons = getResources().getStringArray(R.array.moons);
        distance = getResources().getStringArray(R.array.orbitD);
        period = getResources().getStringArray(R.array.orbitP);
        temp = getResources().getStringArray(R.array.temp);
        date = getResources().getStringArray(R.array.record);
        by = getResources().getStringArray(R.array.by);

        assignValues();
        int location = locationInArray();
        printValues(location);
    }

    public void assignValues()
    {
        planetPicture = (ImageView) findViewById(R.id.imageView);
        PlanetName = (TextView) findViewById(R.id.textView19);
        EquatorialDiameter = (TextView) findViewById(R.id.textView20);
        Mass = (TextView) findViewById(R.id.textView21);
        Moons = (TextView) findViewById(R.id.textView22);
        OrbitDistance = (TextView) findViewById(R.id.textView23);
        OrbitPeriod = (TextView) findViewById(R.id.textView24);
        EffectiveTemperature = (TextView) findViewById(R.id.textView25);
        DiscoveryDate = (TextView) findViewById(R.id.textView26);
        DiscoveredBy = (TextView) findViewById(R.id.textView27);
    }

    public int locationInArray()
    {
        if(myPlanet.toLowerCase().contains("mercury"))
            return 0;
        if(myPlanet.toLowerCase().contains("venus"))
            return 1;
        if(myPlanet.toLowerCase().contains("earth"))
            return 2;
        if(myPlanet.toLowerCase().contains("mars"))
            return 3;
        if(myPlanet.toLowerCase().contains("jupiter"))
            return 4;
        if(myPlanet.toLowerCase().contains("saturn"))
            return 5;
        if(myPlanet.toLowerCase().contains("uranus"))
            return 6;
        if(myPlanet.toLowerCase().contains("neptune"))
            return 7;

        return -1; // not a valid name
    }

    public void printValues(int location)
    {
        PlanetName.setText(planetNames[location]);
        EquatorialDiameter.setText(diameter[location]);
        Mass.setText(mass[location]);
        Moons.setText(moons[location]);
        OrbitDistance.setText(distance[location]);
        OrbitPeriod.setText(period[location]);
        EffectiveTemperature.setText(temp[location]);
        DiscoveryDate.setText(date[location]);
        DiscoveredBy.setText(by[location]);
        planetPicture.setImageResource(listviewImage[location]);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listview_with_image_and_text, container, false);
        return rootView;
    }
}