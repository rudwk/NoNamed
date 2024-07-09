package org.example.crudboad_v2.domain.board.presentation.dto;

import lombok.Getter;
import org.example.crudboad_v2.domain.board.domain.Board;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String userId;
    private String title;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
    }
}
