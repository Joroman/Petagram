package com.josepcode.petagramFragments.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.josepcode.petagramFragments.pojo.MiMascota;
import com.josepcode.petagramFragments.pojo.Pet;
import com.josepcode.petagramFragments.R;

import java.util.ArrayList;

/**
 * Created by JR on 30/05/2016.
 */
public class MiMascotaAdapter extends RecyclerView.Adapter <MiMascotaAdapter.MiMascotaViewHolder> {

    MiMascota mMiMascota;

    public MiMascotaAdapter(MiMascota miMascota) {
        this.mMiMascota = miMascota;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil_pet,parent,false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MiMascotaViewHolder miMascotaViewHolder, int position) {

        miMascotaViewHolder.miMascotaFoto   .setImageResource(mMiMascota.getFotos()[position]);
        miMascotaViewHolder.miMascotalikes  .setText(String.valueOf(mMiMascota.getLikes()[position]));
    }

    @Override
    public int getItemCount() {
        return mMiMascota.getnumberElements();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView miMascotaFoto;
        private TextView miMascotalikes;
        private ImageButton mIBBone;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);

            miMascotaFoto   =(ImageView)    itemView.findViewById(R.id.iv_mimascota_foto);
            miMascotalikes  =(TextView)     itemView.findViewById(R.id.tv_mimascota_likes);
            mIBBone         =(ImageButton)  itemView.findViewById(R.id.ib_bone_color_mimascota);
        }
    }
}
