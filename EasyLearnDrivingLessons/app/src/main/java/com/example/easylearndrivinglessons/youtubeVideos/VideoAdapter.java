package com.example.easylearndrivinglessons.youtubeVideos;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easylearndrivinglessons.Config;
import com.example.easylearndrivinglessons.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private static final String errorMsg = VideoAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<String> videoArrayList2;

    private int selectedPosition = 0;


    public VideoAdapter(Context context, ArrayList<String> videoArrayList2) {
        this.context = context;
        this.videoArrayList2 = videoArrayList2;
    }


    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.youtube_layout, parent, false);
        return new VideoViewHolder(view);
    }


    public void onBindViewHolder(VideoViewHolder holder, final int position) {
        if (selectedPosition == position) {
            holder.youtubeCardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
        } else {
            //if selected position is not equal to that mean view is not selected so change the cardview color to white back again
            holder.youtubeCardView.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
        }

        /*  initialize the thumbnail image view , we need to pass Developer Key */
        holder.videoThumbnailImageView.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                //when initialization is sucess, set the video id to thumbnail to load
                youTubeThumbnailLoader.setVideo(videoArrayList2.get(position));

                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        //when thumbnail loaded successfully release the thumbnail loader as we are showing thumbnail in adapter
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                        //print or show error when thumbnail load failed
                        Log.e(errorMsg, "Youtube Thumbnail Error");
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //print or show error when initialization failed
                Log.e(errorMsg, "Youtube Initialization Failure");

            }
        });

    }


    public int getItemCount() {
        return videoArrayList2 != null ? videoArrayList2.size() : 0;
    }

    /**
     * method the change the selected position when item clicked
     *
     * @param selectedPosition
     */
    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        //when item selected notify the adapter
        notifyDataSetChanged();
    }


}
