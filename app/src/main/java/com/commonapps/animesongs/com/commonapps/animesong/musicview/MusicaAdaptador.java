package com.commonapps.animesongs.com.commonapps.animesong.musicview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.commonapps.animesongs.R;

import java.util.ArrayList;

/**
 * Created by GiovannyGin on 14/06/2016.
 */
public class MusicaAdaptador extends RecyclerView.Adapter<MusicaAdaptador.MusicaViewHolder> {
    private ArrayList<MusicaInformacion> musicaDatos;
    private Context context;
    private OnItemClickListener escuchador;
    @Override
    public MusicaAdaptador.MusicaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_cards,parent,false);
        MusicaViewHolder informacionViewHolder = new MusicaViewHolder(v);
        return informacionViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicaAdaptador.MusicaViewHolder holder, int position) {
        holder.txtNumeroMusica.setText(musicaDatos.get(position).getNumeroMusica());
        holder.txtTituloMusica.setText(musicaDatos.get(position).getTituloMusica());
        holder.txtDuracionMusica.setText(musicaDatos.get(position).getDuracionMusica());
    }

    @Override
    public int getItemCount() {
        return musicaDatos.size();
    }
    interface OnItemClickListener {
        public void onClick(MusicaViewHolder holder, String idPromocion);
    }
    public MusicaAdaptador(ArrayList<MusicaInformacion> mDatos, Context contexto, OnItemClickListener escucha){
        this.musicaDatos=mDatos;
        this.escuchador =escucha;
        this.context=contexto;
    }

    public  class MusicaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        TextView txtNumeroMusica,txtTituloMusica,txtDuracionMusica;

        public MusicaViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cards_musica);
            txtNumeroMusica =(TextView)itemView.findViewById(R.id.numero_musica);
            txtTituloMusica = (TextView)itemView.findViewById(R.id.titulo_musica);
            txtDuracionMusica = (TextView)itemView.findViewById(R.id.duracion_musica);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            escuchador.onClick(this,musicaDatos.get(getAdapterPosition()).getTituloMusica());
        }
    }
}
