package com.sun_asterisk.youtube_background_05.data.source.remote.fetchjson;

import android.os.AsyncTask;
import com.sun_asterisk.youtube_background_05.data.model.YoutubeVideo;
import com.sun_asterisk.youtube_background_05.data.source.remote.OnFetchDataJsonListener;
import org.json.JSONException;
import org.json.JSONObject;

public class GetJsonFromUrl extends AsyncTask<String, Void, String> {

    private OnFetchDataJsonListener<YoutubeVideo> mListener;

    GetJsonFromUrl(OnFetchDataJsonListener<YoutubeVideo> listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        try {
            ParseDataWithJson parseDataWithJson = new ParseDataWithJson();
            data = parseDataWithJson.getJsonFromUrl(strings[0]);
        } catch (Exception e) {
            mListener.onError(e);
        }
        return data;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        if (data != null) {
            try {
                JSONObject jsonObject = new JSONObject(data);
                mListener.onSuccess(new ParseDataWithJson().parseJsonToData(jsonObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
