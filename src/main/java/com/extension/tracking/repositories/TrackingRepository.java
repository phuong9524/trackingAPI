package com.extension.tracking.repositories;

import com.extension.tracking.entities.Tracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends MongoRepository<Tracking, String> {}
