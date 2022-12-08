package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private final ArrayList<Spell> ListSorts;
    private final LayoutInflater inflater;
    public MyAdapter(Context ct, ArrayList<Spell> liste){
        this.ListSorts=liste;
        this.inflater=LayoutInflater.from(ct);

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
        Spell CurrentItem= (Spell) getItem(i);
        TextView Powerm=view.findViewById(R.id.deg_m);
        TextView NameSpell=view.findViewById(R.id.NomDuSort);
        TextView Description=view.findViewById(R.id.descriptionSort);
        TextView Cout=view.findViewById(R.id.cout_pm);
        TableLayout sort = view.findViewById(R.id.Sort);


        int pow=CurrentItem.power;
        String NomSort=CurrentItem.getName();
        NameSpell.setText(NomSort);
        String descrip=CurrentItem.description;
        Description.setText(descrip);
        int couts=CurrentItem.cost;
        Powerm.setText("Degâts: "+pow);


        Cout.setText(couts+" PM");


        return view;
    }
}
