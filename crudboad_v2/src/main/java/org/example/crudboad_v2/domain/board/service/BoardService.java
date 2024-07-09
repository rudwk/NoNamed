package org.example.crudboad_v2.domain.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.crudboad_v2.domain.board.presentation.dto.BoardCreateRequestDto;
import org.example.crudboad_v2.domain.board.presentation.dto.BoardListResponseDto;
import org.example.crudboad_v2.domain.board.presentation.dto.BoardResponseDto;
import org.example.crudboad_v2.domain.board.domain.Board;
import org.example.crudboad_v2.domain.board.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardCreateRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BoardCreateRequestDto requestDto){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글은 존재하지 않음"));

        board.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public BoardResponseDto searchById(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물"));

        return new BoardResponseDto(board);
    }

    @Transactional
    public List<BoardListResponseDto> searchAllDesc(){
        return boardRepository.findAllByOrderByIdDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물 그딴건 없다"));
        boardRepository.delete(board);
    }
}
