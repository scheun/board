package com.my.board.controller;

import com.my.board.model.Board;
import com.my.board.model.PageDTO;
import com.my.board.model.PageParam;
import com.my.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;


//    @GetMapping("/")
//    public String listBoard(Model model) {
//
//        model.addAttribute("board", boardService.listBoard());
//
//        return "board/listBoard";
//    }

    @GetMapping("/")
    public String list(PageParam page, Model model) {

        int total =  boardService.countBoard();
        PageDTO pageDTO = new PageDTO(page, total);

        model.addAttribute("board", boardService.listBoard());
        model.addAttribute("page", pageDTO);
        return "board/listBoard";
    }

    @GetMapping("/board/detailBoard")
    public String detailBoard(Model model, int boardNum, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "member/login";
        } else {
            model.addAttribute("board", boardService.detailBoard(boardNum));
            return "board/detailBoard";
        }
    }

    @GetMapping("/board/insertBoard")
    public String insertBoard(HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/member/login";
        } else {
            return "board/insertBoard";
        }
    }

    @PostMapping("insertBoard")
    @ResponseBody
    public int insertBoard(Board board, HttpSession session) {
        String id = session.getAttribute("id").toString();
        board.setId(id);

        return  boardService.insertBoard(board);
    }


}
