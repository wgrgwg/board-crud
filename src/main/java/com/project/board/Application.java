package com.project.board;

import com.project.board.controller.BoardController;
import com.project.board.controller.PostController;
import com.project.board.controller.ProgramController;
import com.project.board.repository.BoardRepository;
import com.project.board.repository.PostRepository;
import com.project.board.repository.RequestRepository;
import com.project.board.service.BoardService;
import com.project.board.service.PostService;
import com.project.board.service.RequestService;
import com.project.board.view.BoardView;
import com.project.board.view.PostView;
import com.project.board.view.ProgramView;

public class Application {

    public static void main(String[] args) {
        ProgramView programView = new ProgramView();

        RequestRepository requestRepository = new RequestRepository();
        RequestService requestService = new RequestService(requestRepository);

        BoardView boardView = new BoardView();
        BoardRepository boardRepository = new BoardRepository();
        BoardService boardService = new BoardService(boardRepository);
        BoardController boardController = new BoardController(boardService, boardView);

        PostView postView = new PostView();
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostService(postRepository);
        PostController postController = new PostController(postService, postView, boardService);

        ProgramController programController = new ProgramController(
                programView, requestService, boardController,
                postController);

        programController.run();
    }
}
