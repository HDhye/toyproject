package com.hdhye.toyproject.board.controller;
import com.hdhye.toyproject.board.model.service.BoardService;
import com.hdhye.toyproject.board.model.dto.BoardDTO;
import com.hdhye.toyproject.common.Pagination;
import com.hdhye.toyproject.common.SelectCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boardList")
    public Model boardRead(HttpServletRequest request, Model model,
//                           @RequestParam(required = false, defaultValue = "1") int currentPageNo
                           SelectCriteria criteria
    ){



        Pagination.getSelectCriteria(criteria.getCurrentPageNo(), criteria.getTotalCount(), criteria.getLimit(),
                criteria.getButtonAmount(), criteria.getSearchCondition(), criteria.getSearchValue());

        Pagination.getSelectCriteria(criteria.getCurrentPageNo(), criteria.getTotalCount(), criteria.getLimit(), criteria.getButtonAmount());

        List<BoardDTO> boardList = boardService.selectBoardList();

        model.addAttribute("boardList", boardList);
        System.out.println("boardList = " + boardList);

        return model;
    }

    private void getPaging(Model model, int currentPageNo, String url){

    }




}
