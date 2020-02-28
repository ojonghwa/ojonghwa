package com.jojoldu.book.ojonghwa.web.dto;

import com.jojoldu.book.ojonghwa.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {     //p111

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
