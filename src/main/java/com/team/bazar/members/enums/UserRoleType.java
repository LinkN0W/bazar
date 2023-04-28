package com.team.bazar.members.enums;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum UserRoleType implements Role {
    LISTENER, USER, REPORTER, COMMENTER;

    private final Set<Role> children = new HashSet<>();

    static {
        USER.children.addAll(List.of(REPORTER,COMMENTER, LISTENER));
    }
    @Override
    public boolean includes(Role role) {
        return equals(role) || children.stream().anyMatch(r -> r.includes(role));
    }
}
