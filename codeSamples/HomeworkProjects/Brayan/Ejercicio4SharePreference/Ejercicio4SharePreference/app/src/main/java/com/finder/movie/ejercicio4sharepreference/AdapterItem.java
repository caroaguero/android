package com.finder.movie.ejercicio4sharepreference;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterItem extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Usuario> items;

    public AdapterItem (Activity activity, ArrayList<Usuario> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            items.add(usuarios.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.list_item, null);
        }

        Usuario user = items.get(position);

        TextView title = (TextView) v.findViewById(R.id.category);
        title.setText(user.getNombre());

        TextView description = (TextView) v.findViewById(R.id.texto);
        description.setText(user.getEmail());

        //ImageView imagen = (ImageView) v.findViewById(R.id.imageView);
        //imagen.setImageDrawable(user.getImage());

        return v;
    }
}