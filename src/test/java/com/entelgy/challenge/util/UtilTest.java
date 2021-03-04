package com.entelgy.challenge.util;

import com.entelgy.challenge.client.dto.CommentDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    void restructureComments() {
        String expected = "1|0|luis@test.com";
        String actual = Util.restructureComments(mockCommentDto());

        Assert.assertEquals(expected, actual);
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