package com.commonapps.animesongs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;



public class album extends Fragment implements datosAdapter.OnItemClickListener {
private RecyclerView recyclerView;
private LinearLayoutManager layoutManager;
private datosAdapter adapter;

public album(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_album, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.lista_album);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

         ArrayList<datos_album> datos = new ArrayList<>();
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));
        datos.add(new datos_album("Titulo","Descripcion"));

        adapter = new datosAdapter(datos,this.getContext(),this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;

    }


    @Override
    public void onClick(datosAdapter.AlbumViewHolder holder, String idPromocion) {
        Toast.makeText(this.getContext(),idPromocion,Toast.LENGTH_SHORT).show();
    }
}
