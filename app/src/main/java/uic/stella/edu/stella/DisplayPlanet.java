package uic.stella.edu.stella;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    TextView PlanetNameField;
    TextView EquatorialDiameter;
    TextView Mass;
    TextView Moons;
    TextView MoonsField;
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

        //spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        Bundle bundle = getIntent().getExtras();
        myPlanet = bundle.getString("thePlanet");
        final String planetText = "";



        //  Toast.makeText(this, message,
        //    Toast.LENGTH_SHORT).show();

        // final SharedPreferences.Editor editor = (spAppSettings.edit()); // incase we need to change values

        //myPlanet = spAppSettings.getString(current_planet, "");


        listviewImage = new int[]{
                R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars,
                R.drawable.jupiter, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune,
                R.drawable.ariel, R.drawable.dione, R.drawable.hyperion, R.drawable.iapetus, R.drawable.luna,
                R.drawable.miranda, R.drawable.oberon, R.drawable.rhea, R.drawable.tethys, R.drawable.titan
                , R.drawable.titania, R.drawable.triton , R.drawable.umbriel
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

        if(myPlanet.toLowerCase().contains("mercury"))
            setTitle("Mercury");
        if(myPlanet.toLowerCase().contains("venus"))
            setTitle("Venus");
        if(myPlanet.toLowerCase().contains("earth"))
            setTitle("Earth");
        if(myPlanet.toLowerCase().contains("mars"))
            setTitle("Mars");
        if(myPlanet.toLowerCase().contains("jupiter"))
            setTitle("Jupiter");
        if(myPlanet.toLowerCase().contains("saturn"))
            setTitle("Saturn");
        if(myPlanet.toLowerCase().contains("uranus"))
            setTitle("Uranus");
        if(myPlanet.toLowerCase().contains("neptune"))
            setTitle("Neptune");

        if(myPlanet.toLowerCase().contains("ariel")) {
            setTitle("Ariel");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("dione")) {
            setTitle("Dione");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("hyperion")) {
            setTitle("Hyperion");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("iapetus")) {
            setTitle("Iapetus");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("luna")) {
            setTitle("Luna");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("miranda")) {
            setTitle("Miranda");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("oberon")) {
            setTitle("Oberon");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("rhea")) {
            setTitle("Rhea");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("tethys")) {
            setTitle("Tethys");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("titan")) {
            setTitle("Titan");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("titania")) {
            setTitle("Titania");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("triton")) {
            setTitle("Triton");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
        if(myPlanet.toLowerCase().contains("umbriel")) {
            setTitle("Umbriel");
            PlanetName.setVisibility(View.INVISIBLE);
            PlanetNameField.setVisibility(View.INVISIBLE);
            MoonsField.setText("Parent Planet:");
        }
    }

    public void assignValues()
    {
        planetPicture = (ImageView) findViewById(R.id.imageView);
        PlanetName = (TextView) findViewById(R.id.textView19);
        PlanetNameField = (TextView) findViewById(R.id.textView);
        EquatorialDiameter = (TextView) findViewById(R.id.textView20);
        Mass = (TextView) findViewById(R.id.textView21);
        Moons = (TextView) findViewById(R.id.textView22);
        MoonsField = (TextView) findViewById(R.id.textView13);
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

        if(myPlanet.toLowerCase().contains("ariel"))
            return 8;
        if(myPlanet.toLowerCase().contains("dione"))
            return 9;
        if(myPlanet.toLowerCase().contains("hyperion"))
            return 10;
        if(myPlanet.toLowerCase().contains("iapetus"))
            return 11;
        if(myPlanet.toLowerCase().contains("luna"))
            return 12;
        if(myPlanet.toLowerCase().contains("miranda"))
            return 13;
        if(myPlanet.toLowerCase().contains("oberon"))
            return 14;
        if(myPlanet.toLowerCase().contains("rhea"))
            return 15;
        if(myPlanet.toLowerCase().contains("tethys"))
            return 16;
        if(myPlanet.toLowerCase().contains("titania"))
            return 18;
        if(myPlanet.toLowerCase().contains("titan"))
            return 17;
        if(myPlanet.toLowerCase().contains("triton"))
            return 19;
        if(myPlanet.toLowerCase().contains("umbriel"))
            return 20;

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