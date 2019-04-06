package com.example.easylearndrivinglessons.youtubeVideos;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.easylearndrivinglessons.R;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    public YouTubeThumbnailView videoThumbnailImageView;
    public CardView youtubeCardView;

    public VideoViewHolder(View itemView) {
        super(itemView);
        videoThumbnailImageView = itemView.findViewById(R.id.video_thumbnail_image_view);
        youtubeCardView = itemView.findViewById(R.id.youtube_row_card_view);

    }
}