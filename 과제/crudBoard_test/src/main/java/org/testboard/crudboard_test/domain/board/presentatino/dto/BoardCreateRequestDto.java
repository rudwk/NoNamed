package org.testboard.crudboard_test.domain.board.presentatino.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testboard.crudboard_test.domain.board.domain.Board;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private String uesr;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(String user, String title, String content){
        this.uesr = user;
        this.title = title;
        this.content = content;

    }

    public Board toEntity(){
        return Board.builder().content(content).title(title).content(content).build();
    }
}
