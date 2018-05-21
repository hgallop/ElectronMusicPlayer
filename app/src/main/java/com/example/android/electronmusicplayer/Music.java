package com.example.android.electronmusicplayer;

public class Music {

    private final int mImageId;
    private final String mMusicTitle;
    private final String mMusicDescription;
    private int mIdentity;

    Music(int image, String title, String desc, int identity){
        mImageId = image;
        mMusicTitle = title;
        mMusicDescription = desc;
        mIdentity = identity;
    }

    public int getImageId(){
        return mImageId;
    }

    public String getMusicTitle(){
        return mMusicTitle;
    }

    public String getMusicDescription() {
        return mMusicDescription;
    }

    public int getIdentity(){
        return mIdentity;
    }

    public void setIdentity(int identity) {
        mIdentity = identity;
    }
}
