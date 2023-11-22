package com.hdhye.toyproject.board.model.service;


import com.hdhye.toyproject.board.model.dto.BoardDTO;
import com.hdhye.toyproject.board.model.dto.BoardResponse;
import com.hdhye.toyproject.common.SelectCriteria;

import java.util.List;

public interface BoardService {
    int selectTotalCount(SelectCriteria criteria);
    List<BoardDTO> selectBoardList(SelectCriteria criteria);

}
