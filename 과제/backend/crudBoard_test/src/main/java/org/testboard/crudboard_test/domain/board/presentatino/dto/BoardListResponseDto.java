package org.testboard.crudboard_test.domain.board.presentatino.dto;

import lombok.Getter;
import org.testboard.crudboard_test.domain.board.domain.Board;
@Getter
public class BoardListResponseDto {
    private Long id;
    private String user;
    private String title;

    public BoardListResponseDto(Board board){
        this.id = board.getId();
        this.user = board.getUser();
        this.title = board.getTitle();
    }
}
