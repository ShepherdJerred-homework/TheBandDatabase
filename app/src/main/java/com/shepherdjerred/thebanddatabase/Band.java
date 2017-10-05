package com.shepherdjerred.thebanddatabase;

public class Band {
    private int mId;
    private String mName;
    private String mDescription;
    private int mRating;

    public Band() {}

    public Band(int id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;
        mRating = -1;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        this.mRating = rating;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
