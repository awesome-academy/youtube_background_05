package com.sun_asterisk.youtube_background_05.data.source;

import com.sun_asterisk.youtube_background_05.data.model.YoutubeVideo;
import com.sun_asterisk.youtube_background_05.data.source.remote.OnFetchDataJsonListener;

public interface YoutubeDataSource {
    interface RemoteDataSource {
        void getData(OnFetchDataJsonListener<YoutubeVideo> listener);
    }
}
