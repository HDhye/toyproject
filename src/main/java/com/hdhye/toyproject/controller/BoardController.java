package com.hdhye.toyproject.controller;

import com.hdhye.toyproject.model.dto.BoardDTO;
import com.hdhye.toyproject.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.SourceVersion;
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
