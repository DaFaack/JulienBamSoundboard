package com.penta.games.julienbamsoundboard.tabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.penta.games.julienbamsoundboard.MainActivity;
import com.penta.games.julienbamsoundboard.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Ratan on 7/29/2015.
 */
public class Kommentare extends Fragment {
    GridView myGridView;

    int max;
    public String[] items1 ={"aber","alter","wirklich?","beschissen","*BIP*","Kuhl","Das hat nicht geklappt","Das war witzig",
            "doch","DOOH","Dumme Idee","Echt cool, High five","Endlich","Ey","Fresse dahinten","Haa","Hallo","Hmm Schwierig",
            "Huh, was denn?","Ich weiß nicht","Ich weiß nicht wieso","Boah, ich weiß was","Pass ma auf","Ich habe eine Idee","I dont know","Ist echt geil",
            "Ist ja nicht schwer","Das macht keinen Sinn","let's goo","Mit Links","Na gut, dann nicht","Nein","was... was ist das?","so nochmal","Oh","Boah shit","Oke",
            "Oke gut","RAUS!","schon besser","stay fresh","stimmt","ohh","too easy","verdammt",
            "verdammt 2.0","vielleicht doch","warte mal","was ist das","was redest du da"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.kommentare,container,false);


        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        myGridView = (GridView)rootView.findViewById(R.id.torgeGridView);
        myGridView.setAdapter(new CustomGridAdapter(getActivity(), items1));
        myGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                File dest = Environment.getExternalStorageDirectory();

                InputStream in;

                Intent share = new Intent(Intent.ACTION_SEND);
                Intent sharetext = new Intent(Intent.ACTION_SEND);

                switch (pos){
                    case 0:
                        in = getResources().openRawResource(R.raw.aber);
                        break;
                    case 1:
                        in = getResources().openRawResource(R.raw.alter);
                        break;
                    case 2:
                        in = getResources().openRawResource(R.raw.wirklich);
                        break;
                    case 3:
                        in = getResources().openRawResource(R.raw.beschissen);
                        break;
                    case 4:
                        in = getResources().openRawResource(R.raw.bip);
                        break;
                    case 5:
                        in = getResources().openRawResource(R.raw.cool);
                        break;
                    case 6:
                        in = getResources().openRawResource(R.raw.dashatnichtgeklappt);
                        break;
                    case 7:
                        in = getResources().openRawResource(R.raw.daswarwitzig);
                        break;
                    case 8:
                        in = getResources().openRawResource(R.raw.doch);
                        break;
                    case 9:
                        in = getResources().openRawResource(R.raw.doo);
                        break;
                    case 10:
                        in = getResources().openRawResource(R.raw.dummeidee);
                        break;
                    case 11:
                        in = getResources().openRawResource(R.raw.echtcoolhighfive);
                        break;
                    case 12:
                        in = getResources().openRawResource(R.raw.endlich);
                        break;
                    case 13:
                        in = getResources().openRawResource(R.raw.ey);
                        break;
                    case 14:
                        in = getResources().openRawResource(R.raw.fressehalten);
                        break;
                    case 15:
                        in = getResources().openRawResource(R.raw.ha);
                        break;
                    case 16:
                        in = getResources().openRawResource(R.raw.hallo);
                        break;
                    case 17:
                        in = getResources().openRawResource(R.raw.hmschwierig);
                        break;
                    case 18:
                        in = getResources().openRawResource(R.raw.huhwasdenn);
                        break;
                    case 19:
                        in = getResources().openRawResource(R.raw.ichweisnicht);
                        break;
                    case 20:
                        in = getResources().openRawResource(R.raw.ichweisnichtwieso);
                        break;
                    case 21:
                        in = getResources().openRawResource(R.raw.ichweiswas);
                        break;
                    case 22:
                        in = getResources().openRawResource(R.raw.ichzeigdirwasichdraufhabe);
                        break;
                    case 23:
                        in = getResources().openRawResource(R.raw.idee);
                        break;
                    case 24:
                        in = getResources().openRawResource(R.raw.idontknow);
                        break;
                    case 25:
                        in = getResources().openRawResource(R.raw.istechtgeil);
                        break;
                    case 26:
                        in = getResources().openRawResource(R.raw.istjanichtschwer);
                        break;
                    case 27:
                        in = getResources().openRawResource(R.raw.keinensinn);
                        break;
                    case 28:
                        in = getResources().openRawResource(R.raw.letsgo);
                        break;
                    case 29:
                        in = getResources().openRawResource(R.raw.mitlinks);
                        break;
                    case 30:
                        in = getResources().openRawResource(R.raw.nagutdannnicht);
                        break;
                    case 31:
                        in = getResources().openRawResource(R.raw.nein);
                        break;
                    case 32:
                        in = getResources().openRawResource(R.raw.waswasistdas);
                        break;
                    case 33:
                        in = getResources().openRawResource(R.raw.nochmal);
                        break;
                    case 34:
                        in = getResources().openRawResource(R.raw.oh);
                        break;
                    case 35:
                        in = getResources().openRawResource(R.raw.ohshit);
                        break;
                    case 36:
                        in = getResources().openRawResource(R.raw.oke);
                        break;
                    case 37:
                        in = getResources().openRawResource(R.raw.okegut);
                        break;
                    case 38:
                        in = getResources().openRawResource(R.raw.raus);
                        break;
                    case 39:
                        in = getResources().openRawResource(R.raw.schonbesser);
                        break;
                    case 40:
                        in = getResources().openRawResource(R.raw.stayfresh);
                        break;
                    case 41:
                        in = getResources().openRawResource(R.raw.stimmt);
                        break;
                    case 42:
                        in = getResources().openRawResource(R.raw.stoehn);
                        break;
                    case 43:
                        in = getResources().openRawResource(R.raw.tooeasy);
                        break;
                    case 44:
                        in = getResources().openRawResource(R.raw.verdammt);
                        break;
                    case 45:
                        in = getResources().openRawResource(R.raw.verdammt1);
                        break;
                    case 46:
                        in = getResources().openRawResource(R.raw.vielleichtdoch);
                        break;
                    case 47:
                        in = getResources().openRawResource(R.raw.wartemal);
                        break;
                    case 48:
                        in = getResources().openRawResource(R.raw.wasistdas);
                        break;
                    case 49:
                        in = getResources().openRawResource(R.raw.wasredestduda);
                        break;


                    default:
                        in = getResources().openRawResource(R.raw.wirklich);
                        break;
                }


                try
                {
                    OutputStream out = new FileOutputStream(new File(dest, "audio.mp3"));
                    byte[] buf = new byte[1024];
                    int len;
                    while ( (len = in.read(buf, 0, buf.length)) != -1)
                    {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(Environment.getExternalStorageDirectory().toString() + "/audio.mp3"));
                share.setType("audio/mp3");
                startActivity(Intent.createChooser(share, "Sound teilen über..."));


                return true;

            }
        });
        return rootView;
    }




    public class CustomGridAdapter extends BaseAdapter {

        private Context context;
        private String[] items;
        LayoutInflater inflater;

        public CustomGridAdapter(Context c, String[] items) {
            this.context = c;
            this.items = items;
            inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }




        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.single_item, null);
            }
            Button button = (Button) convertView.findViewById(R.id.button);
            button.setText(items[position]);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (context instanceof MainActivity) {
                        ((MainActivity) context).kommentare(position);
                    }
                }
            });

            return convertView;
        }


    }
}

