package org.testboard.crudboard_test.domain.board.presentatino;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardCreateRequestDto;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardListResponseDto;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardResponseDto;
import org.testboard.crudboard_test.domain.board.service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto){
        System.out.println(requestDto.getUser());
        return boardService.create(requestDto);
    }

    @PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardCreateRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto searchById(@PathVariable Long id){
        return boardService.searchById(id);
    }

    @GetMapping("/board")
    public List<BoardListResponseDto> searchAll(){
        return boardService.searchAll();
    }

    @DeleteMapping("/board/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }
}
