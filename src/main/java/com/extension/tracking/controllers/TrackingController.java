package com.extension.tracking.controllers;

import com.extension.tracking.entities.Tracking;
import com.extension.tracking.repositories.TrackingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {
    private final TrackingRepository trackingRepository;

    public TrackingController(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    @PostMapping
    public Tracking track(@RequestBody Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    @GetMapping
    public List<Tracking> getData() {
        return trackingRepository.findAll();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String id) {
        trackingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
