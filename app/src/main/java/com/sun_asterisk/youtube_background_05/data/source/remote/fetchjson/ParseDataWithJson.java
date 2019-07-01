package com.sun_asterisk.youtube_background_05.data.source.remote.fetchjson;

import com.sun_asterisk.youtube_background_05.data.model.YoutubeVideo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseDataWithJson {

    private static final int TIME_OUT = 15000;
    private static final String METHOD_GET = "GET";

    public String getJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(TIME_OUT);
        httpURLConnection.setReadTimeout(TIME_OUT);
        httpURLConnection.setRequestMethod(METHOD_GET);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.connect();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();
        return stringBuilder.toString();
    }

    public List<YoutubeVideo> parseJsonToData(JSONObject jsonObject) {
        List<YoutubeVideo> YtList = new ArrayList<>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray(YoutubeVideo.YoutubeEntry.ITEM);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject YtJson = jsonArray.getJSONObject(i);
                YoutubeVideo youtubeVideo =
                        parseJsonToObject(YtJson.getJSONObject(YoutubeVideo.YoutubeEntry.SNIPPET));
                if (youtubeVideo.getmTitile() != null) {
                    YtList.add(youtubeVideo);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return YtList;
    }

    private YoutubeVideo parseJsonToObject(JSONObject jsonObjectYt) {
        YoutubeVideo youtubeVideo = new YoutubeVideo();
        try {
            youtubeVideo = new YoutubeVideo.Item().id(
                    jsonObjectYt.getInt(YoutubeVideo.YoutubeEntry.POSITION))
                    .title(jsonObjectYt.getString(YoutubeVideo.YoutubeEntry.TITLE))
                    .urlImage(jsonObjectYt.getJSONObject(YoutubeVideo.YoutubeEntry.THUMBNAIL)
                            .getJSONObject(YoutubeVideo.YoutubeEntry.URL_IMAGE)
                            .getString(YoutubeVideo.YoutubeEntry.URL))
                    .videoId(jsonObjectYt.getJSONObject(YoutubeVideo.YoutubeEntry.RESOURCEID)
                            .getString(YoutubeVideo.YoutubeEntry.VIDEOID))
                    .build();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return youtubeVideo;
    }
}
