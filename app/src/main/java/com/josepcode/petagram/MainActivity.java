package com.josepcode.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> mPetArrayList;
    private RecyclerView mRVListaPets;
    private ImageButton mIBEstrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Primero cargamos la ToolBar
        Toolbar mMiActionBar=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(mMiActionBar);

        //Cojemos el objeto RecycleView para pode trabajar con el a nivel de codigo java
        mRVListaPets=(RecyclerView)findViewById(R.id.rv_Contactos);

        //Creamos LinearLayout Manager
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRVListaPets.setLayoutManager(llm);

        inicializarListaPets();
        inicializarAdapter();

        //ImageButton
        mIBEstrella=(ImageButton)findViewById(R.id.ib_estrella);
        mIBEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RankingPetsActivity.class);
                startActivity(intent);
            }
        });


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
