package com.sun_asterisk.youtube_background_05.utils;

public abstract class Constant {

    public final static String BASE_URL = "https://www.googleapis.com/youtube/v3/playlistItems?";
    public final static String BASE_PART = "part=snippet";
    public final static String BASE_URL_PLAYLIST = "&playlistId=" + Constant.PLAYLIST;
    public final static String BASE_MAX_RESULT = "&maxResults=50";
    public final static String BASE_API_KEY = "&key=" + Constant.KEY;
    public final static String KEY = "AIzaSyBuSrtdcY9rmR-d8yKrZu__f7tkdQ1UN7U";
    public final static String PLAYLIST = "PLlxTJYD43NvvyqMvYcwmkN8QdWY9358Qj";
}
