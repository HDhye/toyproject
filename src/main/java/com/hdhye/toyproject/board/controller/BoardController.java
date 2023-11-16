package com.hdhye.toyproject.board.controller;
import com.hdhye.toyproject.board.model.service.BoardService;
import com.hdhye.toyproject.board.model.dto.BoardDTO;
import com.hdhye.toyproject.common.Pagination;
import com.hdhye.toyproject.common.SelectCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public Model selectBoardList(HttpServletRequest request, Model model,
//                           @RequestParam(required = false, defaultValue = "1") int currentPageNo
                           SelectCriteria criteria
    ){

        log.info("[BoardController] selectBoardList ==== criteria ===== {}", criteria);

        criteria.setTotalCount(boardService.selectTotalCount(criteria));
        log.info("[BoardController] selectBoardList ==== criteria.getTotalCount ===== {}", criteria.getTotalCount());

        // 한 페이지에 보여질 게시물 수 (기본 5)
        if(criteria.getLimit() == 0){
            criteria.setLimit(5);
        }

        // 한 번에 보여질 페이징 버튼의 갯수
        criteria.setButtonAmount(5);

        // 검색어 유무에 따라
        if(criteria.getSearchCondition() != null && !criteria.getSearchCondition().equals("")){

        }

        Pagination.getSelectCriteria(criteria.getCurrentPageNo(), criteria.getCategoryCode(), criteria.getTotalCount(), criteria.getLimit(),
                criteria.getButtonAmount(), criteria.getSearchCondition(), criteria.getSearchValue());

        Pagination.getSelectCriteria(criteria.getCurrentPageNo(), criteria.getCategoryCode(), criteria.getTotalCount(), criteria.getLimit(), criteria.getButtonAmount());

        List<BoardDTO> boardList = boardService.selectBoardList();

        model.addAttribute("boardList", boardList);
        System.out.println("boardList = " + boardList);

        return model;
    }

    private void getPaging(Model model, int currentPageNo, String url){

    }




}
