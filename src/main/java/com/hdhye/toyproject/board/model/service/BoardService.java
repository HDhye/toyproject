package com.hdhye.toyproject.board.model.service;


import com.hdhye.toyproject.board.model.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectBoardList();
}
