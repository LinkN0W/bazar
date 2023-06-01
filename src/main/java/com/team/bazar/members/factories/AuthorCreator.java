package com.team.bazar.members.factories;

import com.team.bazar.members.entities.Author;
import com.team.bazar.members.entities.Member;
import com.team.bazar.users.User;

public class AuthorCreator extends MemberCreator{
    @Override
    Member createMember(User user) {
        return new Author(user);
    }
}
