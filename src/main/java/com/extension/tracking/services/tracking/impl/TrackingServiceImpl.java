package com.extension.tracking.services.tracking.impl;

import com.extension.tracking.model.entities.Tracking;
import com.extension.tracking.exceptions.NotFoundException;
import com.extension.tracking.repositories.TrackingRepository;
import com.extension.tracking.services.tracking.TrackingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final TrackingRepository trackingRepository;

    public TrackingServiceImpl(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }
    @Override
    public void deleteTracking(String id) {
        Optional<Tracking> trackingOtp = trackingRepository.findById(id);
        if (trackingOtp.isEmpty()) {
            throw new NotFoundException("Cannot found assign asset with id " + id);
        }
        trackingRepository.deleteById(id);
    }

    @Override
    public Tracking createTracking(Tracking tracking) {
        Optional<Tracking> trackingOpt = trackingRepository.findByVideoIdAndUserChannel(tracking.getVideoId(), tracking.getUserChannel());
        if (trackingOpt.isEmpty()) {
            return trackingRepository.insert(tracking);
        } else {
            trackingOpt.get().setTimeViewed(tracking.getTimeViewed());
            return trackingRepository.save(trackingOpt.get());
        }
    }

    @Override
    public List<Tracking> getAllTracking(String userChannel) {
        return trackingRepository.findByUserChannelOrderByLastModifiedDesc(userChannel);
    }
}
