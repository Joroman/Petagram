package com.josepcode.petagramFragments.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.josepcode.petagramFragments.pojo.Pet;
import com.josepcode.petagramFragments.R;

import java.util.ArrayList;

/**
 * Created by JR on 30/05/2016.
 */
public class PetAdapter extends RecyclerView.Adapter <PetAdapter.PetViewHolder> {

    ArrayList<Pet> mPetArrayList;

    public PetAdapter(ArrayList<Pet> petArrayList) {
        this.mPetArrayList = petArrayList;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet,parent,false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, int position) {
        final Pet pet=mPetArrayList.get(position);

        petViewHolder.mPetFoto  .setImageResource(pet.getFotoPet());
        petViewHolder.mPetName  .setText(pet.getNombre());
        petViewHolder.mPetLikes .setText(String.valueOf(pet.getLikes()));
        petViewHolder.mIBBone   .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),"Diste Like a: " + pet.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPetArrayList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView mPetFoto;
        private TextView mPetName;
        private TextView mPetLikes;
        private ImageButton mIBBone;

        public PetViewHolder(View itemView) {
            super(itemView);

            mPetFoto    =(ImageView)    itemView.findViewById(R.id.iv_foto_pet);
            mPetName    =(TextView)     itemView.findViewById(R.id.tv_pet_name);
            mPetLikes   =(TextView)     itemView.findViewById(R.id.tv_like);
            mIBBone     =(ImageButton)  itemView.findViewById(R.id.ib_bone);
        }
    }
}
