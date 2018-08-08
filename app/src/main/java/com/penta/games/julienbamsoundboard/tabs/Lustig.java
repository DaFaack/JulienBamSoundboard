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
 * Created by Oclemmy on 5/10/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class Lustig extends Fragment{

    GridView myGridView;

    public String[] items2 ={"Ahoo","Chiääa","Danke","Das macht mich sauer!","welcher Depp macht denn so etwas","Gehirn-\naussetzer","häää","haa wieso",
            "Nein, Manfred","Hallo Mama","Hals verrenkt","Helloo","*Heul*","Hey Ju","Hold up","*hue*","Das macht mich sauer","Keine Freunde",
            "KENDAMA","Komplett behindert?","Ahahahaha","Haha","Das ist garnicht witzig","Null Witzig","Okee","Ich trink meine eigene Pisse",
            "So sexy","Wunde an der Lippe","tot","yeeey"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.lustig,container,false);



        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        myGridView = (GridView)rootView.findViewById(R.id.sandraGridView);
        myGridView.setAdapter(new CustomGridAdapter(getActivity(), items2));
        myGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {


                File dest = Environment.getExternalStorageDirectory();

                InputStream in;

                Intent share = new Intent(Intent.ACTION_SEND);

                switch (pos){
                    case 0:
                        in = getResources().openRawResource(R.raw.aho);
                        break;
                    case 1:
                        in = getResources().openRawResource(R.raw.chea);
                        break;
                    case 2:
                        in = getResources().openRawResource(R.raw.danke);
                        break;
                    case 3:
                        in = getResources().openRawResource(R.raw.dasmachtmichsauer);
                        break;
                    case 4:
                        in = getResources().openRawResource(R.raw.depp);
                        break;
                    case 5:
                        in = getResources().openRawResource(R.raw.gehirnaussetzer);
                        break;
                    case 6:
                        in = getResources().openRawResource(R.raw.haa);
                        break;
                    case 7:
                        in = getResources().openRawResource(R.raw.haawieso);
                        break;
                    case 8:
                        in = getResources().openRawResource(R.raw.hallofuss);
                        break;
                    case 9:
                        in = getResources().openRawResource(R.raw.hallomama);
                        break;
                    case 10:
                        in = getResources().openRawResource(R.raw.halsverrengt);
                        break;
                    case 11:
                        in = getResources().openRawResource(R.raw.hello);
                        break;
                    case 12:
                        in = getResources().openRawResource(R.raw.heul);
                        break;
                    case 13:
                        in = getResources().openRawResource(R.raw.heyju);
                        break;
                    case 14:
                        in = getResources().openRawResource(R.raw.holdup);
                        break;
                    case 15:
                        in = getResources().openRawResource(R.raw.hue);
                        break;
                    case 16:
                        in = getResources().openRawResource(R.raw.keinbockmehr);
                        break;
                    case 17:
                        in = getResources().openRawResource(R.raw.keinefreunde);
                        break;
                    case 18:
                        in = getResources().openRawResource(R.raw.kendama);
                        break;
                    case 19:
                        in = getResources().openRawResource(R.raw.komplettbehindert);
                        break;
                    case 20:
                        in = getResources().openRawResource(R.raw.lache);
                        break;
                    case 21:
                        in = getResources().openRawResource(R.raw.lachen);
                        break;
                    case 22:
                        in = getResources().openRawResource(R.raw.nichtwitzig);
                        break;
                    case 23:
                        in = getResources().openRawResource(R.raw.nullwitzig);
                        break;
                    case 24:
                        in = getResources().openRawResource(R.raw.okay);
                        break;
                    case 25:
                        in = getResources().openRawResource(R.raw.pisse);
                        break;
                    case 26:
                        in = getResources().openRawResource(R.raw.sosexy);
                        break;
                    case 27:
                        in = getResources().openRawResource(R.raw.stativ);
                        break;
                    case 28:
                        in = getResources().openRawResource(R.raw.tot);
                        break;
                    case 29:
                        in = getResources().openRawResource(R.raw.yeeey);
                        break;

                    default:
                        in = getResources().openRawResource(R.raw.yeeey);
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
                        ((MainActivity) context).lustig(position);
                    }
                }
            });

            return convertView;
        }


    }
}
