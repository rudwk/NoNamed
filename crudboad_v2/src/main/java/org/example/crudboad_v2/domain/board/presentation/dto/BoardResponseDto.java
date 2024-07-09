package org.example.crudboad_v2.domain.board.presentation.dto;

import lombok.Getter;
import org.example.crudboad_v2.domain.board.domain.Board;

@Getter
public class BoardResponseDto {
    private Long id;
    private String userId;
    private String title;
    private String content;

    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
