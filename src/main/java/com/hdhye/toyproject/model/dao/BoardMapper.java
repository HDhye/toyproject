package com.hdhye.toyproject.model.dao;

import com.hdhye.toyproject.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> selectBoard();
}
