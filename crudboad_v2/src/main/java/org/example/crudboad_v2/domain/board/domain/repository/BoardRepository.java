package org.example.crudboad_v2.domain.board.domain.repository;

import org.example.crudboad_v2.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {//멤버 관리할 때 같이 관리

    List<Board> findAllByOrderByIdDesc();
}