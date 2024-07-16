package org.testboard.crudboard_test.domain.board.presentatino.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.testboard.crudboard_test.domain.board.domain.Board;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private String user;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(String user, String title, String content){
        this.user = user;
        this.title = title;
        this.content = content;

    }

    public Board toEntity(){
        return Board.builder().user(user).title(title).content(content).build();
    }
}
