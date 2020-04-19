package com.manga.reader.network;

import com.manga.reader.network.model.*;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface StoryService {

    @GET("/manga-reader/story-list")
    Single<JsonResponse< ArrayList<Story> >> getStoryList(
            @Query("type_href") String typeHref,
            @Query("page") int page,
            @Query("sort") int sort);

    @GET("/manga-reader/type-list")
    Single<JsonResponse< ArrayList<HrefTitle> >> getTypeList();

    @GET("/manga-reader/story-detail")
    Single<JsonResponse< StoryDetail>> getStoryDetail(
            @Query("story_href") String storyHref);

    @GET("/manga-reader/list-chapters")
    Single<JsonResponse< ArrayList<HrefTitleDate> >> getStoryChapters(
            @Query("story_href") String storyHref);

    @GET("/manga-reader/chapter-detail")
    Single<JsonResponse< ArrayList<String> >> getChapterDetail(
            @Query("chapter_href") String chapterHref,
            @Query("result_type") String resultType);

    @GET("/manga-reader/story-search")
    Single<JsonResponse< ArrayList<Story> >> getStorySearch(
            @Query("q") String q,
            @Query("page") int page);
}
