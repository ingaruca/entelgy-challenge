package com.entelgy.challenge.client.impl;

import com.entelgy.challenge.client.CommentsClient;
import com.entelgy.challenge.client.dto.CommentDto;
import com.entelgy.challenge.config.properties.EntelgyChallengeProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class CommentsClientImpl implements CommentsClient {

    private final EntelgyChallengeProperties properties;
    private final WebClient webClient;

    public CommentsClientImpl(EntelgyChallengeProperties properties) {
        this.properties = properties;
        this.webClient = WebClient.create(properties.getUrl());
    }

    @Override
    public Flux<CommentDto> findAllComments() {
        log.info("Entering client method findAllComments");
        return webClient.get()
                .uri(properties.getPath())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CommentDto.class);
    }

}
