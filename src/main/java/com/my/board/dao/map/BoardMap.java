package com.my.board.dao.map;

import com.my.board.model.Board;

import java.util.List;

public interface BoardMap {
    List<Board> listBoard(int start);
    List<Board> detailBoard(int boardNum);
    int insertBoard(Board board);
    double countBoard();
}
