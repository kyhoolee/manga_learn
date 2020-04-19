package com.manga.reader.network;

import com.manga.reader.network.model.HrefTitleDate;
import com.manga.reader.network.model.JsonResponse;
import com.manga.reader.network.model.Story;
import com.manga.reader.network.model.StoryDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class ApiUtils {

    //https://pizza.yobimind.com/manga-reader/story-list?type_href=http://truyenqq.com/the-loai/adult-68.html&page=2
    public static final String BASE_URL = "https://pizza.yobimind.com";

    public static StoryService getStoryService() {
        return RetrofitClient.getClient(BASE_URL).create(StoryService.class);
    }



}