package com.project.board.constants;

import java.util.Map;
import java.util.Set;

public final class Constant {
    public static final Map<Type, Set<String>> PARAM_KEYS = Map.of(
            Type.BOARDS, Set.of("boardName", "boardId"),
            Type.POSTS, Set.of("boardId", "postId"),
            Type.ACCOUNTS, Set.of("accountId")
    );
}
