package com.hdhye.toyproject.model.service;

import com.hdhye.toyproject.model.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectBoard();
}
