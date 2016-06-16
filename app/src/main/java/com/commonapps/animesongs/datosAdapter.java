package com.commonapps.animesongs;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
    public void onBindViewHolder(final AlbumViewHolder holder, int position) {
        holder.Titulo.setText(mdata.get(position).getTitulo());
        holder.Descripcion.setText(mdata.get(position).getDescripcion());

        Glide.with(context).load(mdata.get(position).geturlAlbum()).into(holder.album);

        holder.compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.compartir);
            }
        });

    }

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menucard, popup.getMenu());
        popup.setOnMenuItemClickListener(new menulistener());
        popup.show();
    }


   public class menulistener implements PopupMenu.OnMenuItemClickListener {

        public menulistener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(context, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public interface OnItemClickListener{
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
        ImageView album,compartir;

        AlbumViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.album);
            Titulo = (TextView)itemView.findViewById(R.id.nombre);
            Descripcion = (TextView)itemView.findViewById(R.id.count);

            album = (ImageView)itemView.findViewById(R.id.imagen);
            compartir=(ImageView)itemView.findViewById(R.id.image_overflow);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            escuchador.onClick(this,mdata.get(getAdapterPosition()).getDescripcion());
        }
    }
}
