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
public class Toast extends Fragment {
    GridView myGridView;
    public String[] items3 ={"American toast","Asian Toast","Burger Toast","Döner Toast","Falling Toast","getoastetes Toast","verkokeltes Toast","Mexican Toast",
            "Mini Toast","Mr. Toast","Salami toast","Toast","Toast Burgher","Toast Burger Toast Mexican Slimani","Toast Burger Toast Slimani","Toast Salami","Toast slimani","Kein Toast mehr, ich kann nicht mehr !"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.toast,container,false);


        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        myGridView = (GridView)rootView.findViewById(R.id.lexaGridView);
        myGridView.setAdapter(new CustomGridAdapter(getActivity(), items3));
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
                        in = getResources().openRawResource(R.raw.americantoast);
                        break;
                    case 1:
                        in = getResources().openRawResource(R.raw.asiantoast);
                        break;
                    case 2:
                        in = getResources().openRawResource(R.raw.burgertoast);
                        break;
                    case 3:
                        in = getResources().openRawResource(R.raw.doenertoast);
                        break;
                    case 4:
                        in = getResources().openRawResource(R.raw.fallingtoast);
                        break;
                    case 5:
                        in = getResources().openRawResource(R.raw.getoastetestoast);
                        break;
                    case 6:
                        in = getResources().openRawResource(R.raw.verkokeltestoast);
                        break;
                    case 7:
                        in = getResources().openRawResource(R.raw.mexicantoast);
                        break;
                    case 8:
                        in = getResources().openRawResource(R.raw.minitoast);
                        break;
                    case 9:
                        in = getResources().openRawResource(R.raw.mistertoast);
                        break;
                    case 10:
                        in = getResources().openRawResource(R.raw.salamitoast);
                        break;
                    case 11:
                        in = getResources().openRawResource(R.raw.toast);
                        break;
                    case 12:
                        in = getResources().openRawResource(R.raw.toastburger);
                        break;
                    case 13:
                        in = getResources().openRawResource(R.raw.toastburgertoastmexicanslimani);
                        break;
                    case 14:
                        in = getResources().openRawResource(R.raw.toastburgertoastslimani);
                        break;
                    case 15:
                        in = getResources().openRawResource(R.raw.toastsalami);
                        break;
                    case 16:
                        in = getResources().openRawResource(R.raw.toastslimani);
                        break;
                    case 17:
                        in = getResources().openRawResource(R.raw.keintoastmehrichkannnichtmehr);
                        break;



                    default:
                        in = getResources().openRawResource(R.raw.keintoastmehrichkannnichtmehr);
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
                        ((MainActivity) context).wtf(position);
                    }
                }
            });

            return convertView;
        }


    }
}

