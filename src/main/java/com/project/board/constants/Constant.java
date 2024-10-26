package com.project.board.constants;

import java.util.Map;
import java.util.Set;

public final class Constant {
    public static final Map<Type, Set<String>> PARAM_KEY_MAP = Map.of(
            Type.BOARDS, Set.of("boardName", "boardId"),
            Type.POSTS, Set.of("boardId", "postId"),
            Type.ACCOUNTS, Set.of("accountId")
    );

    public static final Map<Type, Set<Feature>> TYPE_FEATURE_MAP = Map.of(
            Type.BOARDS, Set.of(Feature.ADD, Feature.EDIT, Feature.REMOVE, Feature.VIEW),
            Type.POSTS, Set.of(Feature.ADD, Feature.EDIT, Feature.REMOVE, Feature.VIEW),
            Type.ACCOUNTS,
            Set.of(Feature.SIGNUP, Feature.SIGNIN, Feature.SIGNOUT, Feature.DETAIL, Feature.EDIT, Feature.REMOVE)
    );

    public static final Map<String, Set<Feature>> BOARDS_FEATURE_KEP_MAP = Map.of(
            "boardId", Set.of(Feature.EDIT, Feature.REMOVE),
            "boardName", Set.of(Feature.VIEW)
    );

    public static final Map<String, Set<Feature>> POST_FEATURE_KEP_MAP = Map.of(
            "postId", Set.of(Feature.EDIT, Feature.REMOVE, Feature.VIEW),
            "boardId", Set.of(Feature.ADD)
    );

    public static final Map<String, Set<Feature>> ACCOUNT_FEATURE_KEY_MAP = Map.of(
            "accountId", Set.of(Feature.DETAIL, Feature.EDIT, Feature.REMOVE)
    );
}
