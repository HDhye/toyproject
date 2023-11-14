package com.hdhye.toyproject.board.model.service;

import com.hdhye.toyproject.board.model.dao.BoardMapper;
import com.hdhye.toyproject.board.model.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> selectBoardList() {
        return boardMapper.selectBoardList();
    }
}
