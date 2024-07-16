package org.testboard.crudboard_test.domain.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.testboard.crudboard_test.domain.board.domain.Board;
import org.testboard.crudboard_test.domain.board.domain.repository.BoardRepository;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardCreateRequestDto;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardListResponsDto;
import org.testboard.crudboard_test.domain.board.presentatino.dto.BoardResponsDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardCreateRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(BoardCreateRequestDto requestDto, Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("게시글 없음"));

        board.update(requestDto.getContent());
        return id;
    }

    @Transactional
    public BoardResponsDto findById(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾지못함"));
        return new BoardResponsDto(board);
    }

    @Transactional
    public List<BoardListResponsDto> findAll(){
        return boardRepository.findAllByOrderByIdDesc().stream()
                .map(BoardListResponsDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾지모탐"));
        boardRepository.delete(board);
    }
}
