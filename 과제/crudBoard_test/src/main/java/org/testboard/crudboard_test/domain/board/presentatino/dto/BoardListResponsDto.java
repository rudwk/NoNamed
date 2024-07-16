package org.testboard.crudboard_test.domain.board.presentatino.dto;

import org.testboard.crudboard_test.domain.board.domain.Board;

public class BoardListResponsDto {
    private Long id;
    private String user;
    private String title;

    public BoardListResponsDto(Board board){
        this.id = board.getId();
        this.user = board.getUser();
        this.title = board.getTitle();
    }
}
