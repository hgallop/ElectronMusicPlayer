package com.example.android.electronmusicplayer;

//class to represent a music item

public class Music {

    //variables for the data the music objects will hold
    private final int mImageId;
    private final String mMusicTitle;
    private final String mMusicDescription;
    private int mIdentity;

    //constructor method for a music object
    Music(int image, String title, String desc, int identity){
        mImageId = image;
        mMusicTitle = title;
        mMusicDescription = desc;
        mIdentity = identity;
    }

    //getter for the image resource id
    public int getImageId(){
        return mImageId;
    }

    //getter for the music title string resource
    public String getMusicTitle(){
        return mMusicTitle;
    }

    //getter for the music description string resource
    public String getMusicDescription() {
        return mMusicDescription;
    }

    //getter for the music identity
    public int getIdentity(){
        return mIdentity;
    }

    //setter for the music identity
    public void setIdentity(int identity) {
        mIdentity = identity;
    }
}
