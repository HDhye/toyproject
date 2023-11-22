package com.hdhye.toyproject.board.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class BoardResponse {

    private BoardDTO board;

    public void setBoard(BoardDTO board) {
        this.board = board;
    }


}
