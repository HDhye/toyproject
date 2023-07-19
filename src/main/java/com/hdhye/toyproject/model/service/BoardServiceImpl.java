package com.hdhye.toyproject.model.service;

import com.hdhye.toyproject.model.dao.BoardMapper;
import com.hdhye.toyproject.model.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> selectBoard() {
        return boardMapper.selectBoard();
    }
}
