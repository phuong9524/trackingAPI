package com.extension.tracking.controllers;

import com.extension.tracking.model.entities.Tracking;
import com.extension.tracking.services.tracking.TrackingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {
    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping
    @CrossOrigin(origins = "chrome-extension://cnolbdgnphcdiaidhoniadghipgbkagf")
    public ResponseEntity<Tracking> createTracking(@RequestBody Tracking tracking) {
        return ResponseEntity.status(HttpStatus.OK).body(trackingService.createTracking(tracking));
    }

    @GetMapping
    @CrossOrigin(origins = "chrome-extension://cnolbdgnphcdiaidhoniadghipgbkagf")
    public ResponseEntity<List<Tracking>> getTracking(@RequestParam String userChannel) {
        return ResponseEntity.status(HttpStatus.OK).body(trackingService.getAllTracking(userChannel));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTracking(@RequestParam String id) {
        trackingService.deleteTracking(id);
        return ResponseEntity.noContent().build();
    }
}
