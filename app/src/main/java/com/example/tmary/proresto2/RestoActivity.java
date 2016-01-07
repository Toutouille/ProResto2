package com.example.tmary.proresto2;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RestoActivity extends Activity {


    private static String id_resto_choisi;
    private static int id_resto_choisi_int;
    private Restaurant RestoChoisi;
    public static final String FAVORI_PREF = "favori_pref";
    public static final String FAVORI_SAVE = "favoriKey";

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
    private static ViewPager mViewPager;

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
        mViewPager.setPageTransformer(true, new DepthPageTransformer());

        //On récupère les données du Bundle
        int pageSelected = 0;
        Bundle b = getIntent().getExtras();
        if (b != null) {
            // On récupère l'id du resto choisi
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
                case "m4":  // Atelier du Burger
                    id_resto_choisi_int = 4;
                    break;
                case "m5":  // A contre sens
                    id_resto_choisi_int = 5;
                    break;
                case "m6":  // Le bistrot 102
                    id_resto_choisi_int = 6;
                    break;
                case "m7":  // La cave à huitres
                    id_resto_choisi_int = 7;
                    break;
                case "m8":  // Anouche
                    id_resto_choisi_int = 8;
                    break;
                case "m9":  // Burger street
                    id_resto_choisi_int = 9;
                    break;
                case "m10":  // Le sans gène
                    id_resto_choisi_int = 10;
                    break;
                case "m11":  //
                    id_resto_choisi_int = 11;
                    break;
                case "m12":
                    id_resto_choisi_int = 12;
                    break;
            }
            RestoChoisi = new Restaurant(this.getApplicationContext(), id_resto_choisi_int, false);
            // On récupère la page correspondante
            pageSelected = RestoChoisi.getPageNum();
            Log.v("RestoActivity.java", "OK");
        }
        // Pour sélectionner la bonne page
        mViewPager.setCurrentItem(pageSelected);
    }

    public void onClickButtonMenu(View v){
        Log.v("onClickButtonMenu", "OK");
        Toast.makeText(this, "Affichage du Menu... ou pas!", Toast.LENGTH_SHORT).show();
    }
    public void onClickButtonReserver(View view) {

        Toast.makeText(this, "OK, réservons !", Toast.LENGTH_SHORT).show();
        // Start BookActivity for the selected restaurant
        Intent intent = new Intent(RestoActivity.this, BookActivity.class);
        //On créer un objet Bundle, c'est ce qui va nous permettre d'envoyer des données à l'autre Activity
        //Bundle objetbunble = new Bundle();
        //objetbunble.putInt(Extra_message, id_resto_choisi_int);
        //On affecte à l'Intent le Bundle que l'on a créé

        int page_selected = mViewPager.getCurrentItem();
        intent.putExtra("page_selected", page_selected);
        startActivity(intent);
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
            // Show NbRestos total pages.
            return Restaurant.NbRestos;
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
            TextView section_label, description, schedule;
            ImageView imageView;
            int pageSelected = getArguments().getInt(ARG_SECTION_NUMBER);

            // Lock on portrait orientation
            this.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // Each page got his own menu
            setHasOptionsMenu(true);

            // Choose the correct style of fragment. Depend of the tab
            if (pageSelected == 1) {
                rootView = inflater.inflate(R.layout.fragment_resto_home, container, false);
                description = (TextView) rootView.findViewById(R.id.description);

                description.setText(getString(R.string.description_ensicaen));
                return rootView;
            }
            else{
                Restaurant Resto = new Restaurant(this.getActivity().getApplicationContext(), pageSelected, false);
                String RestoSchedule = "Lundi : "+Resto.getMySchedule().getMonday()
                        +"\nMardi : "+Resto.getMySchedule().getTuesday()
                        +"\nMercredi : "+Resto.getMySchedule().getWednesday()
                        +"\nJeudi : "+Resto.getMySchedule().getThursday()
                        +"\nVendredi : "+Resto.getMySchedule().getFriday()
                        +"\nSamedi : "+Resto.getMySchedule().getSaturday()
                        +"\nDimanche : "+Resto.getMySchedule().getSunday();
                rootView = inflater.inflate(R.layout.fragment_resto, container, false);
                imageView = (ImageView) rootView.findViewById(R.id.imageResto);
                section_label = (TextView) rootView.findViewById(R.id.section_label);
                description = (TextView) rootView.findViewById(R.id.description);
                schedule = (TextView) rootView.findViewById(R.id.schedule);

                section_label.setText(getString(R.string.section_format, pageSelected));
                description.setText(Resto.getDescription());
                description.setMovementMethod(new ScrollingMovementMethod());
                schedule.setText(RestoSchedule);

                Resto.getImageView(imageView, pageSelected);

                return rootView;

            }
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            // Inflate the menu; this adds items to the action bar if it is present.
            inflater.inflate(R.menu.menu_resto, menu);

            // Get favoris
            SharedPreferences pref = this.getActivity().getSharedPreferences(FAVORI_PREF, Context.MODE_PRIVATE);
            String favori_save = pref.getString(FAVORI_SAVE, "NULL");
            int favori_tab[] = new int[10];
            if(favori_save.equals("NULL"))
            {
                for(int i=0;i<10;i++)
                {
                    favori_tab[i] = 0;
                }
            }
            else
            {
                String[] parts = favori_save.split(":");
                for(int i=0; i<parts.length; i++)
                {
                    favori_tab[i] = Integer.parseInt(parts[i]);
                }
            }

            // Get page number
            int pageSelected = getArguments().getInt(ARG_SECTION_NUMBER);
            Log.v("page selected", String.valueOf(pageSelected));

            // Set the right star
            if(favori_tab[pageSelected-1] == 1)
            {
                menu.getItem(0).setIcon(R.drawable.rate_star_big_on_holo_light);
            }
            else
            {
                menu.getItem(0).setIcon(R.drawable.rate_star_big_off_holo_light);
            }

            super.onCreateOptionsMenu(menu, inflater);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            int pageSelected = getArguments().getInt(ARG_SECTION_NUMBER);

            // If button setting clicked
            if (id == R.id.action_settings)
            {
                Toast.makeText(super.getActivity(), "Non implémenté", Toast.LENGTH_SHORT).show();
                return true;
            }

            // if button like clicked
            if (id == R.id.action_like)
            {
                // Get favoris
                SharedPreferences pref = this.getActivity().getSharedPreferences(FAVORI_PREF, Context.MODE_PRIVATE);
                String favori_save = pref.getString(FAVORI_SAVE, "NULL");
                int favori_tab[] = new int[10];
                if(favori_save.equals("NULL"))
                {
                    for(int i=0;i<10;i++)
                    {
                        favori_tab[i] = 0;
                    }
                }
                else
                {
                    String[] parts = favori_save.split(":");
                    for(int i=0; i<parts.length; i++)
                    {
                        favori_tab[i] = Integer.parseInt(parts[i]);
                    }
                }

                // Toggle icon when start is pressed
                String str_favori_sav = "";
                if(favori_tab[pageSelected-1] == 0)
                {
                    item.setIcon(R.drawable.rate_star_big_on_holo_light);
                    Toast.makeText(super.getActivity(), "Favori ajouté", Toast.LENGTH_SHORT).show();

                    // Save changes
                    favori_tab[pageSelected-1] = 1;
                }
                else
                {
                    item.setIcon(R.drawable.rate_star_big_off_holo_light);
                    Toast.makeText(super.getActivity(), "Favori supprimé", Toast.LENGTH_SHORT).show();

                    // Save changes
                    favori_tab[pageSelected-1] = 0;
                }
                for(int i=0;i<9;i++)
                {
                    str_favori_sav = str_favori_sav + String.valueOf(favori_tab[i]) + ":";
                }
                str_favori_sav = str_favori_sav + favori_tab[9];
                Log.v("str_favori_sav", str_favori_sav);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove(FAVORI_SAVE);
                editor.putString(FAVORI_SAVE, str_favori_sav);
                editor.apply();
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    }


    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    public class CustomPageTransformer implements ViewPager.PageTransformer {
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            View imageView = view.findViewById(R.id.imageZone);
            View contentView = view.findViewById(R.id.page_layout);

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left

                // Counteract the default swipe
                view.setTranslationX(pageWidth * -position);
                if (contentView != null) {
                    // But swipe the contentView
                    contentView.setTranslationX(pageWidth * position);
                }
                if (imageView != null) {
                    // Fade the image in
                    imageView.setAlpha(1 + position);
                }

            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                view.setTranslationX(pageWidth * -position);
                if (contentView != null) {
                    // But swipe the contentView
                    contentView.setTranslationX(pageWidth * position);
                }
                if (imageView != null) {
                    // Fade the image out
                    imageView.setAlpha(1 - position);
                }
            } else { // (1,+Infinity]
                // This page is way off-screen to the right
            }
        }
    }
}
