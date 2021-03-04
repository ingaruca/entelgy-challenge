package com.entelgy.challenge.service;

import com.entelgy.challenge.service.dto.ChallengeResponse;
import reactor.core.publisher.Mono;

public interface CommentService {

    Mono<ChallengeResponse> getAllComments();

}
