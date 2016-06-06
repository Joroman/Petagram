package com.josepcode.petagramFragments.pojo;

/**
 * Created by JR on 30/05/2016.
 */
public class Pet {
    private int mFotoPet;
    private String mNombre;
    private int mLikes;

    public Pet(int fotoPet, String nombre, int likes) {
        mFotoPet = fotoPet;
        mNombre = nombre;
        mLikes = likes;
    }

    public int getFotoPet() {
        return mFotoPet;
    }

    public void setFotoPet(int fotoPet) {
        mFotoPet = fotoPet;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String nombre) {
        mNombre = nombre;
    }

    public int getLikes() {
        return mLikes;
    }

    public void setLikes(int likes) {
        mLikes = likes;
    }
}
