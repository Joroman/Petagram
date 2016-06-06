package com.josepcode.petagramFragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josepcode.petagramFragments.R;
import com.josepcode.petagramFragments.adapters.PetAdapter;
import com.josepcode.petagramFragments.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by JR on 06/06/2016.
 */
public class RecycleViewPetsFragment extends Fragment{
    ArrayList<Pet> mPetArrayList;
    private RecyclerView mRVListaPets;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_recycleview_pets,container,false);
        //Cojemos el objeto RecycleView para pode trabajar con el a nivel de codigo java
        mRVListaPets=(RecyclerView)v.findViewById(R.id.rvMascotas);

        //Creamos LinearLayout Manager
        LinearLayoutManager llm =new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRVListaPets.setLayoutManager(llm);

        inicializarListaPets();
        inicializarAdapter();

        return v;
    }

    public void inicializarAdapter(){
        //inicializamos el Adapter
        PetAdapter petAdapter=new PetAdapter(mPetArrayList);
        mRVListaPets.setAdapter(petAdapter);
    }
    public void inicializarListaPets(){
        mPetArrayList = new ArrayList<Pet>();
        mPetArrayList.add(new Pet(R.drawable.perro1,"Miki",4));
        mPetArrayList.add(new Pet(R.drawable.perro2,"Jako",2));
        mPetArrayList.add(new Pet(R.drawable.perro3,"Moli",3));
        mPetArrayList.add(new Pet(R.drawable.perro4,"Fuego",5));
        mPetArrayList.add(new Pet(R.drawable.perro5,"Estrella",3));
        mPetArrayList.add(new Pet(R.drawable.perro6,"Tomy",1));
        mPetArrayList.add(new Pet(R.drawable.perro7,"Josty",1));
    }
}

