package com.my.board.service;

import com.my.board.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> listBoard();
    List<Board> detailBoard(int boardNum);
    int insertBoard(Board board);
    double countBoard();
    List<Board> pageBoard(int start, int pageCnt);
}
