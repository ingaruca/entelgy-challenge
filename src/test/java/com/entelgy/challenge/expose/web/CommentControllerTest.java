package com.entelgy.challenge.expose.web;

import com.entelgy.challenge.service.CommentService;
import com.entelgy.challenge.service.dto.ChallengeResponse;
import com.entelgy.challenge.service.impl.CommentServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CommentController.class)
@Import({
        CommentController.class,
        CommentServiceImpl.class
})
class CommentControllerTest {

    @MockBean
    private CommentService service;

    @Autowired
    private WebTestClient webTestClient;

    private static final String URL = "/api/v1.0/comments";

    @Test
    void getAllComments() {
        Mockito.when(service.getAllComments())
                .thenReturn(Mono.just(mockCommentServiceDto()));

        webTestClient.get()
                .uri(URL)
                .exchange()
                .expectStatus()
                .isOk();
    }

    private ChallengeResponse mockCommentServiceDto() {
        return ChallengeResponse.builder()
                .data(Collections.singletonList(RandomStringUtils.randomAlphanumeric(11)))
                .build();
    }
}