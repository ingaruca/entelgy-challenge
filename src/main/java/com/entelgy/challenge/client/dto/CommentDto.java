package com.entelgy.challenge.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CommentDto {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

}
