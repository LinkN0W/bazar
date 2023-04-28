package com.team.bazar.members.enums;

import java.util.HashSet;
import java.util.Set;

public enum CommunityRoleType implements Role {
    ADMIN;
    Set<Role> children = new HashSet<>();

    static {
        ADMIN.children.add(AuthorRoleType.EDITOR);
    }
    @Override
    public boolean includes(Role role) {
        return equals(role) || children.stream().anyMatch(r -> r.includes(role));
    }
}
