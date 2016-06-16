package com.commonapps.animesongs.com.commonapps.animesong;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.commonapps.animesongs.R;
import com.commonapps.animesongs.datosAdapter;
import com.commonapps.animesongs.datos_album;

import java.util.ArrayList;

public class album extends AppCompatActivity implements datosAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private datosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.lista_album);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ArrayList<datos_album> datos = new ArrayList<>();
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/xe0XSvm.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/nEtxIM0.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/aeF6Seo.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/NKjiCo9.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/BCRGKPw.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/ENo3Kxx.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/g58DDrK.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/SBbtHsS.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/8OqA0pG.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/z8XCrre.jpg"));
        datos.add(new datos_album("Titulo","Descripcion","http://wallpapercave.com/wp/3ZKlWHD.jpg"));



        adapter = new datosAdapter(datos,this,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        try {
            Glide.with(this).load("http://wallpapercave.com/wp/j7Wqz1x.jpg").into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(datosAdapter.AlbumViewHolder holder, String idPromocion) {

    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
/** fin de la clase  **/
class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}


