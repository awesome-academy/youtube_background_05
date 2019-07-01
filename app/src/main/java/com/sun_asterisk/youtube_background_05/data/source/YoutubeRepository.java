package com.sun_asterisk.youtube_background_05.data.source;

import com.sun_asterisk.youtube_background_05.data.model.YoutubeVideo;
import com.sun_asterisk.youtube_background_05.data.source.remote.OnFetchDataJsonListener;

public class YoutubeRepository {
    private static YoutubeRepository sInstance;
    private YoutubeDataSource.RemoteDataSource mRemoteDataSource;

    private YoutubeRepository(YoutubeDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static YoutubeRepository getsInstance(
            YoutubeDataSource.RemoteDataSource remoteDataSource) {
        if (sInstance == null) {
            sInstance = new YoutubeRepository(remoteDataSource);
        }
        return sInstance;
    }

    public void getData(OnFetchDataJsonListener<YoutubeVideo> listener) {
        mRemoteDataSource.getData(listener);
    }
}
