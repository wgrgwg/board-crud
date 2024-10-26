package com.project.board.service;

import com.project.board.model.Board;
import com.project.board.repository.BoardRepository;

public final class BoardService {
    private final BoardRepository BoardRepository;

    public BoardService(BoardRepository BoardRepository) {
        this.BoardRepository = BoardRepository;
    }

    public void addBoard(String name) {
        Board Board = new Board(name);
        BoardRepository.addBoard(Board);
    }

    public Board findBoardByName(String name) {
        return BoardRepository.findBoardByName(name);
    }

    public Board findBoardById(int id) {
        return BoardRepository.findBoardById(id);
    }

    public void updateBoard(int id, String newName) {
        Board Board = BoardRepository.findBoardById(id);
        if (Board != null) {
            Board.setName(newName);
        }
    }

    public void deleteBoardById(int id) {
        BoardRepository.deleteBoardById(id);
    }

    public boolean validateBoardIdExists(int id) {
        return BoardRepository.findBoardById(id) != null;
    }

    public boolean validateBoardNameExists(String name) {
        return BoardRepository.findBoardByName(name) != null;
    }
}
