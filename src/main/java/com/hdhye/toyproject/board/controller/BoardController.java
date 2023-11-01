package com.hdhye.toyproject.board.controller;
import com.hdhye.toyproject.board.model.service.BoardService;
import com.hdhye.toyproject.board.model.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public Model boardRead(Model model){

        List<BoardDTO> boardList = boardService.selectBoard();

        model.addAttribute("boardList", boardList);
        System.out.println("boardList = " + boardList);

        return model;
    }




}
