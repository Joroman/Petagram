package com.josepcode.petagramFragments.fragments;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.josepcode.petagramFragments.R;
import com.josepcode.petagramFragments.adapters.MiMascotaAdapter;
import com.josepcode.petagramFragments.adapters.PetAdapter;
import com.josepcode.petagramFragments.pojo.MiMascota;
import com.josepcode.petagramFragments.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by JR on 06/06/2016.
 */
public class RecycleViewPerfilFragment extends Fragment {

    MiMascota       mMiMascota;
    RecyclerView    mRVListaMiMascota;
    ImageView       mIVFotoPerfil;
    TextView        mTVNombrePerfil;

    public RecycleViewPerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v =inflater.inflate(R.layout.fragment_recycleview_perfil, container, false);

        mIVFotoPerfil       =(ImageView)v.findViewById(R.id.iv_foto_perfil);
        mTVNombrePerfil     =(TextView)v.findViewById(R.id.tv_nombre_perfil);
        mRVListaMiMascota   =(RecyclerView)v.findViewById(R.id.rvPerfil);

        //Creamos LinearLayout Manager
        GridLayoutManager llm =new GridLayoutManager(v.getContext(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRVListaMiMascota.setLayoutManager(llm);

        inicializarMiMascota();
        inicializarAdapter();

        return v;
    }

    public void inicializarAdapter(){
        //inicializamos el Adapter
        MiMascotaAdapter mascotaAdapter= new MiMascotaAdapter(mMiMascota);

        mRVListaMiMascota.setAdapter(mascotaAdapter);
    }
    public void inicializarMiMascota(){
        int [] fotos= { R.drawable.perro1,R.drawable.perro1,R.drawable.perro1,R.drawable.perro1,R.drawable.perro1,
                        R.drawable.perro1,R.drawable.perro1,R.drawable.perro1,R.drawable.perro1,R.drawable.perro1};
        int [] likes={0,1,4,5,2,1,4,3,2,5};

        mMiMascota = new MiMascota(
                "Miki",
                R.drawable.perro1,
                fotos,
                likes
        );
        //extraemos el drawable en un bitmap
        Drawable originalDrawable = getResources().getDrawable(R.drawable.perro1);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        if (originalBitmap.getWidth() > originalBitmap.getHeight()){
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getHeight(), originalBitmap.getHeight());
        }else if (originalBitmap.getWidth() < originalBitmap.getHeight()) {
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getWidth());
        }

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getWidth());
        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());
        mIVFotoPerfil   .setImageDrawable(roundedDrawable);
        mTVNombrePerfil .setText(mMiMascota.getName());
    }
}
