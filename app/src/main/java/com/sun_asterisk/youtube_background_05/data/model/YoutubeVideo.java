package com.sun_asterisk.youtube_background_05.data.model;

public class YoutubeVideo {

    private int mId;
    private String mTitile;
    private String mUrlImage;
    private String mVideoId;

    public YoutubeVideo() {
    }

    public YoutubeVideo(Item item) {
        mId = item.mId;
        mTitile = item.mTitle;
        mUrlImage = item.mUrlImage;
        mVideoId = item.mVideoId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitile() {
        return mTitile;
    }

    public void setmTitile(String mTitile) {
        this.mTitile = mTitile;
    }

    public String getmUrlImage() {
        return mUrlImage;
    }

    public void setmUrlImage(String mUrlImage) {
        this.mUrlImage = mUrlImage;
    }

    public String getmVideoId() {
        return mVideoId;
    }

    public void setmVideoId(String mVideoId) {
        this.mVideoId = mVideoId;
    }

    public static class Item {

        private int mId;
        private String mTitle;
        private String mUrlImage;
        private String mVideoId;

        public Item(int mId, String mTitle, String mUrlImage) {
            this.mId = mId;
            this.mTitle = mTitle;
            this.mUrlImage = mUrlImage;
        }

        public Item() {
        }

        public Item id(int id) {
            mId = id;
            return this;
        }

        public Item title(String title) {
            mTitle = title;
            return this;
        }

        public Item urlImage(String urlImage) {
            mUrlImage = urlImage;
            return this;
        }

        public Item videoId(String videoId) {
            mVideoId = videoId;
            return this;
        }

        public YoutubeVideo build() {
            return new YoutubeVideo(this);
        }
    }

    public final class YoutubeEntry {
        public static final String ITEM = "items";
        public static final String SNIPPET = "snippet";
        public static final String TITLE = "title";
        public static final String THUMBNAIL = "thumbnails";
        public static final String URL_IMAGE = "medium";
        public static final String URL = "url";
        public static final String POSITION = "position";
        public static final String RESOURCEID = "resourceId";
        public static final String VIDEOID = "videoId";
    }
}
