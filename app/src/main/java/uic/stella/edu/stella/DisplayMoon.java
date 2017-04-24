package uic.stella.edu.stella;


/**
 * Created by Bart on 4/23/2017.
 */

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;

public class DisplayMoon extends Activity {

    GridView gv;
    Context context;
    ArrayList prgmName;
    public String[] gridviewTitle = new String[]{
            "Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune",
    };

    Integer[] gridviewImage = new Integer[]{
            R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupiter,
            R.drawable.saturn, R.drawable.uranus, R.drawable.neptune
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView) findViewById(R.id.moongrid);
        //gv.setAdapter(new DisplayPlanet(this, gridviewTitle,gridviewImage));  // this brakes the build 
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}