package com.example.android.clujtour;

/**
 * Created by root on 1/16/18.
 */

public class Item {
    private int mName;
    private int mDescription;
    private int mImageId=NO_IMAGE_PROVIDE;
    private static final int NO_IMAGE_PROVIDE =-1;
    private int mInfoImgId;

    /**
     * public Constructor
     * @param name name of the object
     * @param description description of object
     * @param imageId presentation image
     * @param infoImageId image for more information
     */
    public Item(int name, int description, int imageId, int infoImageId){
        mName=name;
        mDescription=description;
        mImageId=imageId;
        mInfoImgId=infoImageId;
    }
    // Get methods for each state
    public int getmName(){
        return mName;
    }
    public int getmDescription(){
        return mDescription;
    }
    public int getmImageId(){
        return mImageId;
    }
    public int getmInfoImgId(){
        return mInfoImgId;
    }
    public boolean hasImage(){
        return mImageId !=NO_IMAGE_PROVIDE;
    }
}
