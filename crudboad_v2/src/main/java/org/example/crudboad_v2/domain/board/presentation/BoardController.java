package org.example.crudboad_v2.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import org.example.crudboad_v2.domain.board.presentation.dto.BoardCreateRequestDto;
import org.example.crudboad_v2.domain.board.presentation.dto.BoardListResponseDto;
import org.example.crudboad_v2.domain.board.presentation.dto.BoardResponseDto;
import org.example.crudboad_v2.domain.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/{id}")
    public BoardResponseDto searchById(@PathVariable Long id){
        return boardService.searchById(id);
    }

    @GetMapping("/board")
    public List<BoardListResponseDto> searchAllDesc(){
        return boardService.searchAllDesc();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto){
        return boardService.create(requestDto);
    }

    @PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardCreateRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }
}
