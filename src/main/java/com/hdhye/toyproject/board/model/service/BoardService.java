package com.hdhye.toyproject.board.model.service;


import com.hdhye.toyproject.board.model.dto.BoardDTO;
import com.hdhye.toyproject.common.SelectCriteria;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectBoardList(SelectCriteria criteria);

    int selectTotalCount(SelectCriteria criteria);
}
