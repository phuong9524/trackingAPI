package com.extension.tracking.controllers;

import com.extension.tracking.model.dto.request.UpdateVideoWatchStatusChangeRequest;
import com.extension.tracking.services.videowWatchStatusChange.VideoWatchStatusChangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/video")
public class VideoWatchStatusChangeController {
    private final VideoWatchStatusChangeService videoWatchStatusChangeService;

    public VideoWatchStatusChangeController(VideoWatchStatusChangeService videoWatchStatusChangeService) {
        this.videoWatchStatusChangeService = videoWatchStatusChangeService;
    }

    @PutMapping("/{videoId}/watch-status")
    @CrossOrigin(origins = "chrome-extension://cnolbdgnphcdiaidhoniadghipgbkagf")
    public ResponseEntity<Void> updateWatchStatus(@PathVariable String videoId, @RequestBody UpdateVideoWatchStatusChangeRequest updateVideoWatchStatusChangeRequest) {
        videoWatchStatusChangeService.updateWatchStatus(updateVideoWatchStatusChangeRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{videoId}/watch-status")
    @CrossOrigin(origins = "chrome-extension://cnolbdgnphcdiaidhoniadghipgbkagf")
    public ResponseEntity<String> getStatus(@PathVariable String videoId) {
        return ResponseEntity.status(HttpStatus.OK).body(videoWatchStatusChangeService.getWatchStatusForCurrentVideo(videoId));
    }
}
