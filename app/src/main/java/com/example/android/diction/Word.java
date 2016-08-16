package com.example.android.diction;

/**
 * Created by SINGH on 10-08-2016.
 */
public class Word {
    private String mDefault;
    private String mPunjabi;
    private int mResourceImageId=NO_IMAGE;
    private static final int NO_IMAGE=-1;
    private int mAudioResourceId;
    public Word(String Default,String Punjabi,int audioResourceId){
        mDefault=Default;
        mPunjabi= Punjabi;
        mAudioResourceId=audioResourceId;
    }

    public Word(String Default,String Punjabi,int imageResourceId,int audioResourceId){
        mDefault=Default;
        mPunjabi= Punjabi;
        mResourceImageId=imageResourceId;
        mAudioResourceId=audioResourceId;
    }

    public String getDefaultTranslation(){
        return mDefault;
    }
    public String getPunjabiTranslation(){
        return mPunjabi;
    }
    public int getimageResourceId(){
        return mResourceImageId;
    }
    public boolean hasImage(){
    return mResourceImageId!=NO_IMAGE;
    }
    public int getmAudioResourceId(){
        return mAudioResourceId;
    }
}
