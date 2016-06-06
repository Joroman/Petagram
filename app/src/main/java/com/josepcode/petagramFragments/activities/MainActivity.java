package com.josepcode.petagramFragments.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.josepcode.petagramFragments.R;
import com.josepcode.petagramFragments.adapters.PageAdapter;
import com.josepcode.petagramFragments.adapters.PetAdapter;
import com.josepcode.petagramFragments.fragments.RecycleViewPerfilFragment;
import com.josepcode.petagramFragments.fragments.RecycleViewPetsFragment;
import com.josepcode.petagramFragments.pojo.Pet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ImageButton mIBEstrella;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //ya tenenmos el objeto RecyclerView para poder trabajar con codigo java
        //  mlistaContactos =(RecyclerView) findViewById(R.id.rvContactos);
        mViewPager      =(ViewPager)findViewById(R.id.viewPager);
        mTabLayout      =(TabLayout)findViewById(R.id.tabLayout);
        setUpViewPager();

        if(mToolbar!=null){
            setSupportActionBar(mToolbar);
        }

        //ImageButton
        mIBEstrella = (ImageButton) findViewById(R.id.ib_estrella);
        mIBEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RankingPetsActivity.class);
                startActivity(intent);
            }
        });
    }
    //Este método tomará nuestro recurso menu y los inflará
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    //controlar las opciones del menu tenemos que sobreescrivir el método onOptionsItemSelect
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intentA= new Intent(this,ContactoActivity.class);
                startActivity(intentA);
                break;
            case R.id.mViewDetail:
                Intent intentB= new Intent(this,BioActivity.class);
                startActivity(intentB);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
 private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();

        fragments.add(new RecycleViewPetsFragment());
        fragments.add(new RecycleViewPerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.dog_house_48);
        mTabLayout.getTabAt(1).setIcon(R.drawable.year_of_dog_48);

    }

}

