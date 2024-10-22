package com.project.board;

import com.project.board.controller.BoardController;
import com.project.board.repository.PostRepository;
import com.project.board.service.PostService;
import com.project.board.view.BoardView;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        BoardView boardView = new BoardView();
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostService(postRepository);

        BoardController boardController = new BoardController(boardView, postService);

        boardController.run();
    }
}
