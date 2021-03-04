package com.entelgy.challenge.client;

import com.entelgy.challenge.client.dto.CommentDto;
import reactor.core.publisher.Flux;

public interface CommentsClient {

    Flux<CommentDto> findAllComments();

}
