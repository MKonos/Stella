package com.example.mihalis.stellamainapp;

/**
 * Created by Mihalis on 3/14/2017.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab1SolarSystem extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1solarsystem, container, false);
        return rootView;
    }
}
