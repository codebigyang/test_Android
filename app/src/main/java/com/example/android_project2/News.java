package com.example.android_project2;
//新闻类
public class News {
    private String mTitle;
    private String mAuthor;
    private String mContent;
    private int mImageId;

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getContent() {
        return mContent;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }

}
