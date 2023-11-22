package com.hdhye.toyproject.board.model.dto;

import com.hdhye.toyproject.common.SelectCriteria;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
public class BoardListRes {

    private List<BoardDTO> board;
    private SelectCriteria selectCriteria;

    public BoardListRes(List<BoardDTO> board, SelectCriteria selectCriteria) {
        this.board = board;
        this.selectCriteria = selectCriteria;
    }
}
