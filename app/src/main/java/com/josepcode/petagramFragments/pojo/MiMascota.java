package com.josepcode.petagramFragments.pojo;

/**
 * Created by JR on 06/06/2016.
 */
public class MiMascota {
    private String mName;
    private int mFotoPerfil;
    private int [] mFotos;
    private int [] mLikes;

    public MiMascota(String name, int fotoPerfil, int[] fotos, int[] likes) {
        mName = name;
        mFotoPerfil = fotoPerfil;
        mFotos = fotos;
        mLikes = likes;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getFotoPerfil() {
        return mFotoPerfil;
    }

    public void setFotoPerfil(int fotoPerfil) {
        mFotoPerfil = fotoPerfil;
    }

    public int[] getFotos() {
        return mFotos;
    }

    public void setFotos(int[] fotos) {
        mFotos = fotos;
    }

    public int[] getLikes() {
        return mLikes;
    }

    public void setLikes(int[] likes) {
        mLikes = likes;
    }

    public int getnumberElements(){

        return  mFotos.length;
    }
}
