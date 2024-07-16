package org.testboard.crudboard_test.domain.board.presentatino;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardCreateRequestDto;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardListResponsDto;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardResponsDto;
import org.testboard.crudboard_test.domain.board.service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto){
        return boardService.create(requestDto);
    }

    @PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardCreateRequestDto requestDto){
        return boardService.update(requestDto, id);
    }

    @GetMapping("/board/{id}")
    public BoardResponsDto findById(@PathVariable Long id){
        return boardService.findById(id);
    }

    @GetMapping("/board")
    public List<BoardListResponsDto> findAll(){
        return boardService.findAll();
    }

    @DeleteMapping("/board/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }
}
