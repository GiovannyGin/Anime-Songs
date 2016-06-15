package com.commonapps.animesongs;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;



public class album extends Fragment implements datosAdapter.OnItemClickListener {
private RecyclerView recyclerView;
private GridLayoutManager layoutManager;
private datosAdapter adapter;
    private Intent mActions;

public album(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

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
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        }
        else{
            recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        }
        //layoutManager = new GridLayoutManager(this.getContext(),2);
        //recyclerView.setLayoutManager(layoutManager);



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

        FragmentManager fragmentManager = getFragmentManager();
       // fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, new Class<MusicAt>()).commit();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
