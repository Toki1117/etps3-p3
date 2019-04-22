package com.example.myapplication;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TbasMapsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    View vista;
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    public int pagination = 0;

    public TbasMapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista =  inflater.inflate(R.layout.fragment_tbas_maps, container, false);

        pagination = 0;
        if (pagination==0){

            View parent = (View) container.getParent();

            if (appBar==null) {
                appBar = parent.findViewById(R.id.appBar);
                tabs = new TabLayout(getActivity());
                appBar.addView(tabs);

                viewPager = vista.findViewById(R.id.pager);
                llenarViewPager(viewPager);

                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                tabs.setupWithViewPager(viewPager);
            }
        } else {
            pagination = 1;
        }
        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {

        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getFragmentManager());
        vpAdapter.addFragment(new Map1(),"Canadá");
        vpAdapter.addFragment(new Map2(),"Japón");
        vpAdapter.addFragment(new Map3(),"Isla de Pascua");
        vpAdapter.addFragment(new Map4(),"Madagascar");

        viewPager.setAdapter(vpAdapter);

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (pagination==0){
            appBar.removeView(tabs);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
