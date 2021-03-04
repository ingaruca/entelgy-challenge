package com.entelgy.challenge.util;

import com.entelgy.challenge.client.dto.CommentDto;

public class Util {

    private Util() {}

    public static String restructureComments(CommentDto comment) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(comment.getPostId());
        stringBuilder.append("|");
        stringBuilder.append(comment.getId());
        stringBuilder.append("|");
        stringBuilder.append(comment.getEmail());

        return stringBuilder.toString();
    }

}
