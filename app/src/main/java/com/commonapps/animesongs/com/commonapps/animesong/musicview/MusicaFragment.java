package com.commonapps.animesongs.com.commonapps.animesong.musicview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.commonapps.animesongs.R;

import java.util.ArrayList;

/**
 * Created by GiovannyGin on 14/06/2016.
 */
public class MusicaFragment extends Fragment implements MusicaAdaptador.OnItemClickListener {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private MusicaAdaptador adaptador;

    public MusicaFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_music,container,false);


        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = (RecyclerView)v.findViewById(R.id.lista_canciones);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<MusicaInformacion> items = new ArrayList<>();
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));
        items.add(new MusicaInformacion("1", "AO HARU RIDE", "3:30"));

        adaptador = new MusicaAdaptador(items,this.getContext(),this);
        recyclerView.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
        return v;
    }

    @Override
    public void onClick(MusicaAdaptador.MusicaViewHolder holder, String idPromocion) {

    }
}
