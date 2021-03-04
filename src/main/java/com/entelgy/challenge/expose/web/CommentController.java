package com.entelgy.challenge.expose.web;

import com.entelgy.challenge.service.CommentService;
import com.entelgy.challenge.service.dto.ChallengeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @GetMapping("/comments")
    public ResponseEntity<Mono<ChallengeResponse>> getAllComments() {
        return ResponseEntity.ok(service.getAllComments());
    }

}
