package com.sun_asterisk.youtube_background_05.data.source.remote;

import com.sun_asterisk.youtube_background_05.data.model.YoutubeVideo;
import com.sun_asterisk.youtube_background_05.data.source.YoutubeDataSource;
import com.sun_asterisk.youtube_background_05.data.source.remote.fetchjson.GetDataJson;

public class YoutubeRemoteDataSource implements YoutubeDataSource.RemoteDataSource {

    private static YoutubeRemoteDataSource sInstance;

    public static YoutubeRemoteDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new YoutubeRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getData(OnFetchDataJsonListener<YoutubeVideo> listener) {
        GetDataJson getDataJson = new GetDataJson(listener);
        getDataJson.getData();
    }
}
