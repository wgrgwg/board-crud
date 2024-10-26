package com.project.board;

import com.project.board.controller.AccountController;
import com.project.board.controller.BoardController;
import com.project.board.controller.PostController;
import com.project.board.controller.ProgramController;
import com.project.board.repository.AccountRepository;
import com.project.board.repository.BoardRepository;
import com.project.board.repository.PostRepository;
import com.project.board.repository.RequestRepository;
import com.project.board.service.AccountService;
import com.project.board.service.BoardService;
import com.project.board.service.PostService;
import com.project.board.service.RequestService;
import com.project.board.view.AccountView;
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

        PostView postView = new PostView();
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostService(postRepository);

        AccountView accountView = new AccountView();
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);

        PostController postController = new PostController(postService, postView, boardService);
        BoardController boardController = new BoardController(boardService, boardView, postService);
        AccountController accountController = new AccountController(accountService, accountView);

        ProgramController programController = new ProgramController(
                programView, requestService, boardController,
                postController, accountController);

        programController.run();
    }
}
