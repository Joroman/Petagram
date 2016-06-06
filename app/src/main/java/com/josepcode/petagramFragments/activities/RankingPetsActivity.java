package com.josepcode.petagramFragments.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.josepcode.petagramFragments.R;
import com.josepcode.petagramFragments.adapters.PetAdapter;
import com.josepcode.petagramFragments.pojo.Pet;

import java.util.ArrayList;

public class RankingPetsActivity extends AppCompatActivity {

    ArrayList<Pet> mPetArrayList;
    private RecyclerView mRVListaPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_pets);



        //Primero cargamos la ToolBar
        Toolbar mMiActionBar=(Toolbar)findViewById(R.id.miActionBar_1);
        setSupportActionBar(mMiActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Cojemos el objeto RecycleView para pode trabajar con el a nivel de codigo java
        mRVListaPets= (RecyclerView) findViewById(R.id.rv_Contactos_1);
        //Creamos LinearLayout Manager
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRVListaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdapter();

    }

    public void inicializarAdapter(){
        //inicializamos el Adapter
        PetAdapter petAdapter=new PetAdapter(mPetArrayList);
        mRVListaPets.setAdapter(petAdapter);
    }
    public void inicializarListaPets(){
        mPetArrayList = new ArrayList<Pet>();
        mPetArrayList.add(new Pet(R.drawable.perro4,"Fuego",5));
        mPetArrayList.add(new Pet(R.drawable.perro1,"Miki",4));
        mPetArrayList.add(new Pet(R.drawable.perro3,"Moli",3));
        mPetArrayList.add(new Pet(R.drawable.perro5,"Estrella",3));
        mPetArrayList.add(new Pet(R.drawable.perro2,"Jako",2));
    }
}
