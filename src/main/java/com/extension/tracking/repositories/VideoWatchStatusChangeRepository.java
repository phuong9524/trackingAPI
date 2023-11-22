package com.extension.tracking.repositories;

import com.extension.tracking.model.entities.VideoWatchStatusChange;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoWatchStatusChangeRepository extends MongoRepository<VideoWatchStatusChange, String> {
    Optional<VideoWatchStatusChange> findByVideoId(String videoId);

}
