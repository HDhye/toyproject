package com.hdhye.toyproject.board.model.dao;

import com.hdhye.toyproject.board.model.dto.BoardDTO;
import com.hdhye.toyproject.board.model.dto.BoardResponse;
import com.hdhye.toyproject.common.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {

    int selectTotalCount(SelectCriteria criteria);
    List<BoardDTO> selectBoardList(SelectCriteria criteria);
}
