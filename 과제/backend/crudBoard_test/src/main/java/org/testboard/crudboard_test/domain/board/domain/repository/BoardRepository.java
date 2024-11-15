package org.testboard.crudboard_test.domain.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.testboard.crudboard_test.domain.board.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByIdDesc();
}
