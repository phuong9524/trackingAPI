package com.extension.tracking.services.videowWatchStatusChange;

import com.extension.tracking.model.dto.request.UpdateVideoWatchStatusChangeRequest;


public interface VideoWatchStatusChangeService {
    void updateWatchStatus(UpdateVideoWatchStatusChangeRequest updateVideoWatchStatusChangeRequest);

    String getWatchStatusForCurrentVideo(String videoId);
}
