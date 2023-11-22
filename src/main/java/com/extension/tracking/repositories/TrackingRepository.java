package com.extension.tracking.repositories;

import com.extension.tracking.model.entities.Tracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackingRepository extends MongoRepository<Tracking, String> {
    Optional<Tracking> findByVideoIdAndUserChannel(String videoId, String userChannel);

    List<Tracking> findByUserChannelOrderByLastModifiedDesc(String userChannel);

}
