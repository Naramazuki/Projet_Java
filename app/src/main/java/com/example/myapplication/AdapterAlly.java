package com.example.myapplication;

import android.content.Context;
import android.media.tv.TvContract;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterAlly extends BaseAdapter {


    private final ArrayList<Characters> ListTeam;
    private final int [] charList;
    private final LayoutInflater inflater;
    public AdapterAlly(Context ct, ArrayList<Characters> liste,int [] charList){
        this.ListTeam=liste;
        this.charList=charList;
        this.inflater=LayoutInflater.from(ct);

    }
    @Override
    public int getCount() {
        return this.ListTeam.size();
    }

    @Override
    public Object getItem(int i) {
        return this.ListTeam.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.adapter_equipe_enemy,null);
        Characters CurrentItem= (Characters) getItem(i);
        ImageView LogoEnemy=view.findViewById(R.id.Image_Enemy);
        ProgressBar hp_enemy=view.findViewById(R.id.PvBar_Enemy);
        LogoEnemy.setBackgroundResource(charList[i]);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hp_enemy.setProgress((int)CurrentItem.hp/100*CurrentItem.hp_act,true);
        }





        return view;
    }
}


