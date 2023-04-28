package com.team.bazar.members.enums;

import java.util.HashSet;
import java.util.Set;

public enum AuthorRoleType implements Role {
    AUTHOR, EDITOR;

    Set<Role> children = new HashSet<>();

    static {
        EDITOR.children.add(UserRoleType.USER);
        AUTHOR.children.add(EDITOR);
    }

    @Override
    public boolean includes(Role role) {
        return equals(role) || children.stream().anyMatch(r -> r.includes(role));
    }
}
