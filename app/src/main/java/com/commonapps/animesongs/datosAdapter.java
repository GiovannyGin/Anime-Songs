package com.commonapps.animesongs;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kevin on 11/06/16.
 */
public class datosAdapter extends  RecyclerView.Adapter<datosAdapter.AlbumViewHolder> {
    private ArrayList<datos_album>mdata;
    private Context context;
    private OnItemClickListener escuchador;

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_album, parent, false);
        AlbumViewHolder datosViewHolder = new AlbumViewHolder(v);
        return datosViewHolder;
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.Titulo.setText(mdata.get(position).getTitulo());
        //holder.Descripcion.setText(mdata.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    interface OnItemClickListener{
        public void onClick(AlbumViewHolder holder, String idPromocion);

    }



    public datosAdapter(ArrayList<datos_album> mDataSet, Context contexto,OnItemClickListener escucha) {
        this.mdata = mDataSet;
        this.escuchador = escucha;
        this.context = contexto;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        TextView Titulo,Descripcion;

        AlbumViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.album);
            Titulo = (TextView)itemView.findViewById(R.id.nombre);
            //Descripcion = (TextView)itemView.findViewById(R.id.Descripcion);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            escuchador.onClick(this,mdata.get(getAdapterPosition()).getDescripcion());
        }
    }
}
