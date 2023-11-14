package com.extension.tracking.entities;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document(collection = "tracking")
public class Tracking {
    @Id
    private String id;
    private String userId;
    private long timeViewed;
    private long totalVideoTime;
}
