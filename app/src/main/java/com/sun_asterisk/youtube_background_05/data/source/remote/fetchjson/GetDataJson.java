package com.sun_asterisk.youtube_background_05.data.source.remote.fetchjson;

import com.sun_asterisk.youtube_background_05.data.model.YoutubeVideo;
import com.sun_asterisk.youtube_background_05.data.source.remote.OnFetchDataJsonListener;
import com.sun_asterisk.youtube_background_05.utils.Constant;

public class GetDataJson {

    private OnFetchDataJsonListener<YoutubeVideo> mListener;

    public GetDataJson(OnFetchDataJsonListener<YoutubeVideo> listener) {
        mListener = listener;
    }

    public void getData() {
        String url = Constant.BASE_URL
                + Constant.BASE_PART
                + Constant.BASE_URL_PLAYLIST
                + Constant.BASE_API_KEY
                + Constant.BASE_MAX_RESULT;
        new GetJsonFromUrl(mListener).execute(url);
    }
}
