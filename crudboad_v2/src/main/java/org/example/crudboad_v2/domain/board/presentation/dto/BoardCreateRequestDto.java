package org.example.crudboad_v2.domain.board.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.crudboad_v2.domain.board.domain.Board;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private String userId;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(String userId, String title, String content){
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .build();
    }
}
