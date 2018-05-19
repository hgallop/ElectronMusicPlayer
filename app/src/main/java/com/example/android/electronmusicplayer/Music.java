package com.example.android.electronmusicplayer;

public class Music {

    private int mImageId;
    private String mMusicTitle;
    private String mMusicDescription;

    Music(int image, String title, String desc){
        mImageId = image;
        mMusicTitle = title;
        mMusicDescription = desc;
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
}
