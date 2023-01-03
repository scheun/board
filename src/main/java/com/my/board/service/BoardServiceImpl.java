package com.my.board.service;

import com.my.board.dao.map.BoardMap;
import com.my.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMap boardMap;

    @Override
    public List<Board> listBoard() {
        return boardMap.listBoard();
    }

    @Override
    public List<Board> detailBoard(int boardNum) {
        return boardMap.detailBoard(boardNum);
    }

    @Override
    public int insertBoard(Board board) {
        return boardMap.insertBoard(board);
    }

    @Override
    public double countBoard() {
        return boardMap.countBoard();
    }

    @Override
    public List<Board> pageBoard(int start, int pageCnt) {
        return boardMap.pageBoard(start, pageCnt);
    }
}
