package com.example.tmary.proresto2;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

public class RestoActivity extends Activity {


    private static String id_resto_choisi;
    private int id_resto_choisi_int;
    private Restaurant RestoChoisi;
    /**
     * That will provide fragments for each of the sections. We use a
     * FragmentPagerAdapter derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a FragmentStatePagerAdapter.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * That will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        //On récupère les données du Bundle
        int pageSelected = 0;
        Bundle b = getIntent().getExtras();
        if (b != null) {
            id_resto_choisi = b.getString("id_resto_choisi");
            switch(id_resto_choisi) {
                case "m1":  // ENSICAEN
                    id_resto_choisi_int = 1;
                    break;
                case "m2":  // Dolly's
                    id_resto_choisi_int = 2;
                    break;
                case "m3":  // RUA
                    id_resto_choisi_int = 3;
                    break;
                case "m4":  // Burger
                    id_resto_choisi_int = 4;
                    break;
            }
            RestoChoisi = new Restaurant(this.getApplicationContext(), id_resto_choisi_int-1);
            pageSelected = RestoChoisi.getPageNum();
            Log.v("RestoActivity.java", "OK");
            String name = RestoChoisi.getName();
            Log.v("RestoActivity.java",name);
        }
        // Pour sélectionner la bonne page
        mViewPager.setCurrentItem(pageSelected);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getIdRestoChoisi() {
        return id_resto_choisi;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.title_ensicaen);
                case 1:
                    return getString(R.string.title_resto_dollys);
                case 2:
                    return getString(R.string.title_resto_rua);
                case 3:
                    return getString(R.string.title_resto_atelier_burger);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            TextView textView;
            ImageView imageView;
            int pageSelected = getArguments().getInt(ARG_SECTION_NUMBER);

            // Choose the correct style of fragment. Depend of the tab
            if (pageSelected == 1) {
                rootView = inflater.inflate(R.layout.fragment_resto_home, container, false);
                textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER))
                        + "\nC'est une école : " + id_resto_choisi);
                return rootView;
            }
            else{
                rootView = inflater.inflate(R.layout.fragment_resto, container, false);
                imageView = (ImageView) rootView.findViewById(R.id.imageZone);
                textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER))
                        + "\nLe resto choisi est : " + id_resto_choisi);

                switch(pageSelected) {
                    case 2:
                        imageView.setImageResource(R.drawable.logo_rest1);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.logo_rest2);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.logo_rest3);
                        break;
                }

                return rootView;

            }
        }
    }
}
