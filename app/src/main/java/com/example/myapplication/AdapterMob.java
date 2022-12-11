package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterMob extends BaseAdapter {


        private final ArrayList<Characters> ListMob;
        private final LayoutInflater inflater;
        public AdapterMob(Context ct, ArrayList<Characters> liste){
            this.ListMob=liste;
            this.inflater=LayoutInflater.from(ct);

        }
        @Override
        public int getCount() {
            return this.ListMob.size();
        }

        @Override
        public Object getItem(int i) {
            return this.ListMob.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=inflater.inflate(R.layout.adapter_mob,null);
            Characters CurrentItem= (Characters) getItem(i);
            TextView NomMob=view.findViewById(R.id.NomDuMob);
            TextView Pv=view.findViewById(R.id.Pv_Ennemy);


            String NomduMob=CurrentItem.name;
            int PvMob=CurrentItem.hp_act;

            Pv.setText("PV: "+PvMob);

            NomMob.setText(NomduMob);




            return view;
        }
    }


