package com.my.board.controller;

import com.my.board.model.Board;
import com.my.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    
    @GetMapping("/")
    public String pageBoard(Model model, @RequestParam(defaultValue = "1") int page) {
        int totalCnt = (int) Math.ceil(boardService.countBoard()/5);
        int start = (page - 1) * 5;
        if (page <3) {
            int startPage = 1;
            int endPage = 5;
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
        } else if (page == totalCnt || page == (totalCnt -1)){
            int startPage = page - 2;
            int endPage = totalCnt;
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
        }  else {
            int startPage = page - 2;
            int endPage = page + 2;
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
        }

        model.addAttribute("page", page);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("board", boardService.listBoard(start));

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
