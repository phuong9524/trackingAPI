package com.extension.tracking.model.entities;

import com.extension.tracking.model.enums.WatchStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "video_watch_status_changes")
@Getter
@Setter
@NoArgsConstructor
public class VideoWatchStatusChange {
    @Id
    private String id;
    private String videoId;
    private WatchStatus watchStatus;
    private String timeViewed;
    private String totalVideoTime;
}
