package com.hdhye.toyproject.board.controller;
import com.hdhye.toyproject.board.model.dto.BoardListRes;
import com.hdhye.toyproject.board.model.dto.BoardResponse;
import com.hdhye.toyproject.board.model.service.BoardService;
import com.hdhye.toyproject.board.model.dto.BoardDTO;
import com.hdhye.toyproject.common.Pagination;
import com.hdhye.toyproject.common.ResponseDTO;
import com.hdhye.toyproject.common.SelectCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> selectBoardList(HttpServletRequest request, Model model,
//                           @RequestParam(required = false, defaultValue = "1") int currentPageNo
                                                       @ModelAttribute SelectCriteria criteria
    ){

        /* 게시물 카운팅 조회 */
        log.info("[BoardController] selectBoardList ==== criteria ===== {}", criteria);
        int count = boardService.selectTotalCount(criteria);
        log.info("[BoardController] selectBoardList ==== count ===== {}", count);
        criteria.setTotalCount(count);
        log.info("[BoardController] selectBoardList ==== criteria.getTotalCount ===== {}", criteria.getTotalCount());

        // 한 페이지에 보여질 게시물 수 (기본 5)
        if(criteria.getLimit() == 0){
            criteria.setLimit(5);
        }

        // 한 번에 보여질 페이징 버튼의 갯수
        criteria.setButtonAmount(5);

        // 검색어 유무에 따라
        if(criteria.getSearchCondition() != null && !criteria.getSearchCondition().equals("")){
            criteria = Pagination.getSelectCriteria(criteria.getCurrentPageNo(), criteria.getCategoryCode(),
                    criteria.getTotalCount(), criteria.getLimit(), criteria.getButtonAmount(),
                    criteria.getSearchCondition(), criteria.getSearchValue());
        } else {

            criteria = Pagination.getSelectCriteria(criteria.getCurrentPageNo(), criteria.getCategoryCode(),
                    criteria.getTotalCount(), criteria.getLimit(), criteria.getButtonAmount());
        }
        log.info("[BoardController] selectBoardList ==== criteria ===== {}", criteria);

        /* 게시물 조회 */
        List<BoardDTO> boardList = boardService.selectBoardList(criteria);

        model.addAttribute("boardList", boardList);
        System.out.println("boardList = " + boardList);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(),"SelectBoardList",
                new BoardListRes(boardService.selectBoardList(criteria), criteria)));
    }

    private void getPaging(Model model, int currentPageNo, String url){

    }




}
