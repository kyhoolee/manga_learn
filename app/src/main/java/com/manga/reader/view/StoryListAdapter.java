package com.manga.reader.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.manga.reader.R;
import com.manga.reader.network.ImageLoader;
import com.manga.reader.network.model.Story;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.StoryViewHolder> {
    private Context context;
    private List<Story> storyList;
    private StoryListAdapter.StoryListAdapterListener listener;

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.story_cover)
        ImageView storyCover;

        @BindView(R.id.story_title)
        TextView storyTitle;

        @BindView(R.id.story_desc)
        TextView storyDesc;

        public StoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onStorySelected(storyList.get(getAdapterPosition()));
                }
            });
        }
    }

    public StoryListAdapter(Context context, List<Story> storyList, StoryListAdapter.StoryListAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.storyList = storyList;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_row, parent, false);

        return new StoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, final int position) {
        final Story story = storyList.get(position);

        // Set cover
        // Loader image - will be shown before loading image
        int loader = R.drawable.loader;
        ImageLoader imgLoader = new ImageLoader(this.context);
        Map<String, String> headers = new HashMap<String, String>() {{
            put("Referer",    "http://truyenqq.com");
            put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");

        }};
        imgLoader.DisplayImage(story.getCover_url(), headers, loader, holder.storyCover);


        // Set title
        holder.storyTitle.setText(story.getTitle());

        // Set description
        holder.storyDesc.setText(story.getMore_info().getExcerpt());
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public interface StoryListAdapterListener {
        void onStorySelected(Story story);
    }
}