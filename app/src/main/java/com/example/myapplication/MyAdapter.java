package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context ct;
    private ArrayList<Spell> ListSorts;
    private LayoutInflater inflater;
    public MyAdapter(Context ct, ArrayList<Spell> liste){
        this.ct=ct;
        this.ListSorts=liste;
        this.inflater=LayoutInflater.from(this.ct);

    }
    @Override
    public int getCount() {
        return this.ListSorts.size();
    }

    @Override
    public Object getItem(int i) {
        return this.ListSorts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.adapter_item,null);
        Spell n;
        Spell CurrentItem= (Spell) getItem(i);
        String NomSort=CurrentItem.getName();
        TextView NameSpell=view.findViewById(R.id.NomDuSort);
        NameSpell.setText(NomSort);
        return view;
    }
}
