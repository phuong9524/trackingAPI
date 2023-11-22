package com.extension.tracking.model.entities;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Setter
@Getter
@Document(collection = "tracking")
public class Tracking {
    @Id
    private String id;
    private String videoId;
    private String videoUrl;
    private String videoTitle;
    private String username;
    private String userChannel;
    private String timeViewed;
    private String totalVideoTime;
    @LastModifiedDate
    private Date lastModified;

}
