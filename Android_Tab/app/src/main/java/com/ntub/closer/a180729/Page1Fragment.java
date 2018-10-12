package com.ntub.closer.a180729;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class Page1Fragment extends Fragment {


    private View mainView;
    public Page1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (mainView == null) {
            mainView = inflater.inflate(R.layout.fragment_page1, container, false);
        }
        return mainView;
    }



}
