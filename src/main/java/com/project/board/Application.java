package com.project.board;

import com.project.board.controller.ProgramController;
import com.project.board.repository.PostRepository;
import com.project.board.repository.RequestRepository;
import com.project.board.service.PostService;
import com.project.board.service.RequestService;
import com.project.board.view.ProgramView;

public class Application {

    public static void main(String[] args) {
        ProgramView programView = new ProgramView();
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostService(postRepository);

        RequestRepository requestRepository = new RequestRepository();
        RequestService requestService = new RequestService(requestRepository);

        ProgramController programController = new ProgramController(programView, postService, requestService);

        programController.run();
    }
}
