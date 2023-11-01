package com.hdhye.toyproject.board.model.dao;

import com.hdhye.toyproject.board.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> selectBoard();
}
