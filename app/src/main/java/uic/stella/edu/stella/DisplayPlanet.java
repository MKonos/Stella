package uic.stella.edu.stella;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
    TextView effectiveTemperature;
    TextView DiscoveryDate;
    TextView DiscoveredBy;
    SharedPreferences spAppSettings;

    String myPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_info);

        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor = (spAppSettings.edit());


       myPlanet = spAppSettings.getString(current_planet, "");





        int[] listviewImage = new int[]{
                R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars,
                R.drawable.jupiter, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune,
        };

        String[] planetNames = getResources().getStringArray(R.array.planets);
        String[] diamaters = getResources().getStringArray(R.array.diameter);
        String[] mass = getResources().getStringArray(R.array.mass);
        String[] moons = getResources().getStringArray(R.array.moons);
        String[] distance = getResources().getStringArray(R.array.orbitD);
        String[] period = getResources().getStringArray(R.array.orbitP);
        String[] temp = getResources().getStringArray(R.array.temp);
        String[] date = getResources().getStringArray(R.array.record);
        String[] by = getResources().getStringArray(R.array.by);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listview_with_image_and_text, container, false);
        return rootView;
    }
}