package com.greenwoods.productions.julienbamsoundboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer mp;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(MainActivity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2859881364147521/2179542378");
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            // Listen for when user closes ad
            public void onAdClosed() {
                // When user closes ad end this activity (go back to first activity)
                super.onAdClosed();

            }
        });

        final File FILES_PATH = new File(Environment.getExternalStorageDirectory(), "Android/data/com.aaron.waller.miimiisoundboard/files");


        if (Environment.MEDIA_MOUNTED.equals(

                Environment.getExternalStorageState())) {

            if (!FILES_PATH.mkdirs()) {

                Log.w("error", "Could not create " + FILES_PATH);

            }

        } else {

            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();

            finish();

        }


        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                1);
        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         *
         *
         *
         */
        mNavigationView.setItemIconTintList(null);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();



                if(menuItem.getItemId() == R.id.teilen){
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.greenwoods.productions.julienbamsoundboard");
                    startActivity(Intent.createChooser(shareIntent,  "Teilen über..."));
                }


                if (menuItem.getItemId() == R.id.nav_item_inbox) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }



                if (menuItem.getItemId() == R.id.rechtliches) {
                    AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                    a_builder.setMessage(R.string.rechtliches)
                            .setCancelable(true)
                            .setNegativeButton("Verstanden", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Impressum");
                    alert.show();
                }


                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();


    }


    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }
            });
        } else {
            super.onBackPressed();
        }

    }


    public void kommentare(int position) {

        if (position == 0) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.aber);
            mp.start();
        } else if (position == 1) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.alter);
            mp.start();
        } else if (position == 2) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.wirklich);
            mp.start();
        } else if (position == 3) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.beschissen);
            mp.start();
        } else if (position == 4) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.bip);
            mp.start();
        } else if (position == 5) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.cool);
            mp.start();
        } else if (position == 6) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.dashatnichtgeklappt);
            mp.start();
        } else if (position == 7) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.daswarwitzig);
            mp.start();
        } else if (position == 8) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.doch);
            mp.start();
        } else if (position == 9) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.doo);
            mp.start();
        } else if (position == 10) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.dummeidee);
            mp.start();
        } else if (position == 11) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.echtcoolhighfive);
            mp.start();
        } else if (position == 12) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.endlich);
            mp.start();
        } else if (position == 13) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ey);
            mp.start();
        } else if (position == 14) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.fressehalten);
            mp.start();
        } else if (position == 15) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ha);
            mp.start();
        } else if (position == 16) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.hallo);
            mp.start();
        } else if (position == 17) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.hmschwierig);
            mp.start();
        } else if (position == 18) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.huhwasdenn);
            mp.start();
        } else if (position == 19) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ichweisnicht);
            mp.start();
        } else if (position == 20) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ichweisnichtwieso);
            mp.start();
        } else if (position == 21) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ichweiswas);
            mp.start();
        } else if (position == 22) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ichzeigdirwasichdraufhabe);
            mp.start();
        } else if (position == 23) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.idee);
            mp.start();
        }else if (position == 24) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.idontknow);
            mp.start();
        }else if (position == 25) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.istechtgeil);
            mp.start();
        }else if (position == 26) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.istjanichtschwer);
            mp.start();
        }else if (position == 27) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.keinensinn);
            mp.start();
        }else if (position == 28) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.letsgo);
            mp.start();
        }else if (position == 29) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.mitlinks);
            mp.start();
        }else if (position == 30) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.nagutdannnicht);
            mp.start();
        }else if (position == 31) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.nein);
            mp.start();
        }else if (position == 32) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.waswasistdas);
            mp.start();
        }else if (position == 33) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.nochmal);
            mp.start();
        }else if (position == 34) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.oh);
            mp.start();
        }else if (position == 35) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.ohshit);
            mp.start();
        }else if (position == 36) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.oke);
            mp.start();
        }else if (position == 37) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.okegut);
            mp.start();
        }else if (position == 38) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.raus);
            mp.start();
        }else if (position == 39) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.schonbesser);
            mp.start();
        }else if (position == 40) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.stayfresh);
            mp.start();
        }else if (position == 41) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.stimmt);
            mp.start();
        }else if (position == 42) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.stoehn);
            mp.start();
        }else if (position == 43) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.tooeasy);
            mp.start();
        }else if (position == 44) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.verdammt);
            mp.start();
        }else if (position == 45) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.verdammt1);
            mp.start();
        }else if (position == 46) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.vielleichtdoch);
            mp.start();
        }else if (position == 47) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.wartemal);
            mp.start();
        }else if (position == 48) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.wasistdas);
            mp.start();
        }else if (position == 49) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.wasredestduda);
            mp.start();
        }
    }
    public void lustig(int position) {
        if (position == 0) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.aho);
            mp.start();
        } else if (position == 1) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.chea);
            mp.start();
        } else if (position == 2) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.danke);
            mp.start();
        } else if (position == 3) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.dasmachtmichsauer);
            mp.start();
        } else if (position == 4) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.depp);
            mp.start();
        } else if (position == 5) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.gehirnaussetzer);
            mp.start();
        } else if (position == 6) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.haa);
            mp.start();
        } else if (position == 7) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.haawieso);
            mp.start();
        } else if (position == 8) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.hallofuss);
            mp.start();
        } else if (position == 9) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.hallomama);
            mp.start();
        } else if (position == 10) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.halsverrengt);
            mp.start();
        } else if (position == 11) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.hello);
            mp.start();
        } else if (position == 12) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.heul);
            mp.start();
        } else if (position == 13) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.heyju);
            mp.start();
        } else if (position == 14) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.holdup);
            mp.start();
        } else if (position == 15) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.hue);
            mp.start();
        } else if (position == 16) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.keinbockmehr);
            mp.start();
        } else if (position == 17) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.keinefreunde);
            mp.start();
        } else if (position == 18) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.kendama);
            mp.start();
        } else if (position == 19) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.komplettbehindert);
            mp.start();
        } else if (position == 20) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.lache);
            mp.start();
        } else if (position == 21) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.lachen);
            mp.start();
        } else if (position == 22) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.nichtwitzig);
            mp.start();
        } else if (position == 23) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.nullwitzig);
            mp.start();
        } else if (position == 24) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.okay);
            mp.start();
        } else if (position == 25) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.pisse);
            mp.start();
        } else if (position == 26) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.sosexy);
            mp.start();
        } else if (position == 27) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.stativ);
            mp.start();
        } else if (position == 28) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.tot);
            mp.start();
        } else if (position == 29) {
            cleanUpMediaPlayer();
            mp = MediaPlayer.create(MainActivity.this, R.raw.yeeey);
            mp.start();
        }

    }
    public void wtf ( int position){
            if (position == 0) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.americantoast);
                mp.start();
            } else if (position == 1) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.asiantoast);
                mp.start();
            } else if (position == 2) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.burgertoast);
                mp.start();
            } else if (position == 3) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.doenertoast);
                mp.start();
            } else if (position == 4) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.fallingtoast);
                mp.start();
            } else if (position == 5) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.getoastetestoast);
                mp.start();
            } else if (position == 6) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.verkokeltestoast);
                mp.start();
            } else if (position == 7) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.mexicantoast);
                mp.start();
            } else if (position == 8) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.minitoast);
                mp.start();
            } else if (position == 9) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.mistertoast);
                mp.start();
            } else if (position == 10) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.salamitoast);
                mp.start();
            } else if (position == 11) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.toast);
                mp.start();
            } else if (position == 12) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.toastburger);
                mp.start();
            } else if (position == 13) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.toastburgertoastmexicanslimani);
                mp.start();
            } else if (position == 14) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.toastburgertoastslimani);
                mp.start();
            } else if (position == 15) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.toastsalami);
                mp.start();
            } else if (position == 16) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.toastslimani);
                mp.start();
            } else if (position == 17) {
                cleanUpMediaPlayer();
                mp = MediaPlayer.create(MainActivity.this, R.raw.keintoastmehrichkannnichtmehr);
                mp.start();
            }
        }



    public void cleanUpMediaPlayer() {
        if (mp != null) {
            try {
                mp.stop();
                mp.release();
                mp = null;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "swag", Toast.LENGTH_LONG).show();

            }
        }
    }

}
