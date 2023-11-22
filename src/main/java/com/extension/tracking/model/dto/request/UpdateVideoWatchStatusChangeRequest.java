package com.extension.tracking.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateVideoWatchStatusChangeRequest {
    private String videoId;
    private String timeViewed;
    private String totalVideoTime;
}
