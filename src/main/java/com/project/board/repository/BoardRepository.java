package com.project.board.repository;

import com.project.board.model.Board;
import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private final List<Board> boards = new ArrayList<>();

    public void addBoard(Board board) {
        boards.add(board);
    }

    public Board findBoardById(int id) {
        for (Board board : boards) {
            if (board.getId() == id) {
                return board;
            }
        }

        return null;
    }

    public boolean deleteBoardById(int id) {
        for (Board board : boards) {
            if (board.getId() == id) {
                boards.remove(board);
                return true;
            }
        }

        return false;
    }

    public List<Board> getAllBoards() {
        return boards;
    }
}
