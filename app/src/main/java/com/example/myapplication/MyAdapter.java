package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
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
        TextView Powerp=view.findViewById(R.id.deg_p);
        TextView Powerm=view.findViewById(R.id.deg_m);
        TextView NameSpell=view.findViewById(R.id.NomDuSort);
        TextView Description=view.findViewById(R.id.descriptionSort);
        TextView Cout=view.findViewById(R.id.cout_pm);
        TableLayout sort = view.findViewById(R.id.Sort);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        int pow=CurrentItem.power;
        String NomSort=CurrentItem.getName();
        NameSpell.setText(NomSort);
        String descrip=CurrentItem.description;
        Description.setText(descrip);
        int couts=CurrentItem.cost;

        Cout.setText(couts+" PM");
        if(CurrentItem.isPhysical()){
            Powerp.setText("degp: "+pow);
            Powerm.setText("degm: 0");
        }
        else{
            Powerm.setText("degp: "+pow);
            Powerp.setText("degp: 0");
        }

        return view;
    }
}
