package com.example.eduardopalacios.buscadoryoutube.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.eduardopalacios.buscadoryoutube.Holders.ItemHolders;
import com.example.eduardopalacios.buscadoryoutube.R;
import com.example.eduardopalacios.buscadoryoutube.clasesGson.Item;
import com.example.eduardopalacios.buscadoryoutube.clasesPOJO.Items;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by oemy9 on 19/05/2018.
 */

public class AdapterItem extends ArrayAdapter<Items> {

    List<Items> datos;
    Context context;
    int resource;
    public AdapterItem ( Context context, int resource,  List<Items>datos) {
        super(context, resource, datos);

        this.context=context;
        this.resource=resource;
        this.datos=datos;
    }

    @NonNull
    @Override
    public View getView (int position,  View convertView,  ViewGroup parent) {

        View vista;
        vista=convertView;
        ItemHolders itemHolders=null;
        if (vista==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            vista=inflater.inflate(resource,parent,false);
            itemHolders=new ItemHolders();

            itemHolders.imagen=vista.findViewById(R.id.imagenyoutube);
            itemHolders.titulo=vista.findViewById(R.id.titulovideo);
            itemHolders.canal=vista.findViewById(R.id.canal);


            vista.setTag(itemHolders);

        }
        else {
           itemHolders=(ItemHolders)vista.getTag();
        }
        Picasso.with(context).load(datos.get(position).getImagen()).into(itemHolders.imagen);
        itemHolders.titulo.setText(datos.get(position).getTitulo());
        itemHolders.canal.setText(datos.get(position).getDescripcion());

        return vista;
    }
}
