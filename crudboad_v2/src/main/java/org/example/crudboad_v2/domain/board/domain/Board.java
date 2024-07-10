package org.example.crudboad_v2.domain.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

    @Getter
    @NoArgsConstructor
    @Entity
    @Table(name = "board")
    public class Board {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_id")
        private Long id;

        @Column(nullable = false)
        private String userId;

        @Column(nullable = false)
        private String title;

        @Column(columnDefinition = "TEXT")
        private String content;

        @Builder
        public Board(String userId, String title, String content){
            this.userId = userId;
            this.title = title;
            this.content = content;
        }

        public void update(String title, String content){
            this.title = title;
            this.content = content;
        }

    }
