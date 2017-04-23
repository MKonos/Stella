package uic.stella.edu.stella;

/**
 * Created by Bart on 4/21/2017.
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

    public class MainActivityNew extends Activity {
        GridView grid;
        String[] web = {
                "Earth","Jupiter","Mars","Mercury","Neptune" , "Saturn","Uranus","Venus"

        } ;
        int[] imageId = {
                R.drawable.earth,
                R.drawable.jupiter,
                R.drawable.mars,
                R.drawable.mercury,
                R.drawable.neptune,
                R.drawable.saturn,
                R.drawable.uranus,
                R.drawable.venus,


        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            CustomGrid adapter = new CustomGrid(MainActivityNew.this, web, imageId);
            grid=(GridView)findViewById(R.id.grid);
            grid.setAdapter(adapter);
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(MainActivityNew.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

