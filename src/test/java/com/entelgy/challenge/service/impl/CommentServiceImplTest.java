package com.entelgy.challenge.service.impl;

import com.entelgy.challenge.client.CommentsClient;
import com.entelgy.challenge.client.dto.CommentDto;
import com.entelgy.challenge.service.dto.ChallengeResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

@ExtendWith(SpringExtension.class)
@Import({CommentServiceImpl.class})
class CommentServiceImplTest {

    @MockBean
    private CommentsClient commentsClient;

    @Autowired
    private CommentServiceImpl service;

    @Test
    void getAllComments() {
        Mockito.when(commentsClient.findAllComments())
                .thenReturn(Flux.just(mockCommentDto()));

        Mono<ChallengeResponse> obj = service.getAllComments();

        StepVerifier.create(obj)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }

    private CommentDto mockCommentDto() {
        return CommentDto.builder()
                .postId(NumberUtils.INTEGER_ONE)
                .id(NumberUtils.INTEGER_ZERO)
                .email("luis@test.com")
                .body(RandomStringUtils.randomAlphanumeric(11))
                .build();
    }
}