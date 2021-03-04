package com.entelgy.challenge.service.impl;

import com.entelgy.challenge.client.CommentsClient;
import com.entelgy.challenge.service.CommentService;
import com.entelgy.challenge.service.dto.ChallengeResponse;
import com.entelgy.challenge.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentsClient client;

    @Override
    public Mono<ChallengeResponse> getAllComments() {
        log.info("Entering method getAllComments");
        return client.findAllComments()
                .collectList()
                .map(list -> ChallengeResponse.builder()
                        .data(list.stream()
                                .map(Util::restructureComments)
                                .collect(Collectors.toList()))
                        .build());
    }
}
