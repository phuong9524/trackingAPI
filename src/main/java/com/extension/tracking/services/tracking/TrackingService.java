package com.extension.tracking.services.tracking;

import com.extension.tracking.model.entities.Tracking;

import java.util.List;

public interface TrackingService {
    void deleteTracking(String id);
    Tracking createTracking(Tracking tracking);
    List<Tracking> getAllTracking(String userChannel);
}
