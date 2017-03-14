package com.example.mihalis.stellamainapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mihalis on 3/14/2017.
 */
public class Tab2PlanetInfo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2planetinfo, container, false);

        //Button mars = (Button) AppCompatActivity.findViewById(R.id.MarsButton);
        return rootView;

    }


}
