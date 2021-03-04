package com.entelgy.challenge.client.impl;

import com.entelgy.challenge.client.CommentsClient;
import com.entelgy.challenge.client.dto.CommentDto;
import com.entelgy.challenge.config.properties.EntelgyChallengeProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
class CommentsClientImplTest {

    EntelgyChallengeProperties properties;
    CommentsClient client;
    ObjectMapper objectMapper;

    public MockWebServer mockBackEnd;

    @BeforeEach
    void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterEach
    void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        properties = new EntelgyChallengeProperties(mockBackEnd.url("/").toString(), "/comments");
        client = new CommentsClientImpl(properties);
        objectMapper = new ObjectMapper();
    }

    @Test
    void findAllComments() throws JsonProcessingException {
        mockBackEnd.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(CommentDto.builder().build()))
                .addHeader("Content-Type", "application/json"));

        Flux<CommentDto> obj = client.findAllComments();

        StepVerifier.create(obj)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }
}