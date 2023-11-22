package com.extension.tracking.services.videowWatchStatusChange.impl;

import com.extension.tracking.model.dto.request.UpdateVideoWatchStatusChangeRequest;
import com.extension.tracking.model.entities.VideoWatchStatusChange;
import com.extension.tracking.model.enums.WatchStatus;
import com.extension.tracking.repositories.VideoWatchStatusChangeRepository;
import com.extension.tracking.services.videowWatchStatusChange.VideoWatchStatusChangeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoWatchStatusChangeImpl implements VideoWatchStatusChangeService {

    private final VideoWatchStatusChangeRepository videoWatchStatusChangeRepository;

    public VideoWatchStatusChangeImpl(VideoWatchStatusChangeRepository videoWatchStatusChangeRepository) {
        this.videoWatchStatusChangeRepository = videoWatchStatusChangeRepository;
    }
    @Override
    public void updateWatchStatus(UpdateVideoWatchStatusChangeRequest updateVideoWatchStatusChangeRequest) {
        WatchStatus watchStatus = WatchStatus.INCOMPLETE;
        if (updateVideoWatchStatusChangeRequest.getTimeViewed().equals(updateVideoWatchStatusChangeRequest.getTotalVideoTime())) {
            watchStatus = WatchStatus.COMPLETE;
        }
        Optional<VideoWatchStatusChange> videoWatchStatusChangeOtp = videoWatchStatusChangeRepository.findByVideoId(updateVideoWatchStatusChangeRequest.getVideoId());
        if (videoWatchStatusChangeOtp.isPresent()) {
            videoWatchStatusChangeOtp.get().setTimeViewed(updateVideoWatchStatusChangeRequest.getTimeViewed());
            videoWatchStatusChangeOtp.get().setTotalVideoTime(updateVideoWatchStatusChangeRequest.getTotalVideoTime());
            videoWatchStatusChangeOtp.get().setWatchStatus(watchStatus);
            videoWatchStatusChangeRepository.save(videoWatchStatusChangeOtp.get());
        } else {
            VideoWatchStatusChange newVideo = new VideoWatchStatusChange();
            newVideo.setVideoId(updateVideoWatchStatusChangeRequest.getVideoId());
            newVideo.setWatchStatus(watchStatus);
            newVideo.setTotalVideoTime(updateVideoWatchStatusChangeRequest.getTotalVideoTime());
            newVideo.setTimeViewed(updateVideoWatchStatusChangeRequest.getTimeViewed());
            videoWatchStatusChangeRepository.insert(newVideo);
        }
    }

    @Override
    public String getWatchStatusForCurrentVideo(String videoId) {
        Optional<VideoWatchStatusChange> videoWatchStatusChangeOtp = videoWatchStatusChangeRepository.findByVideoId(videoId);
        return videoWatchStatusChangeOtp.map(videoWatchStatusChange -> videoWatchStatusChange.getWatchStatus().toString()).orElse(null);
    }
}
