package com.team.bazar.members.factories;

import com.team.bazar.members.entities.Listener;
import com.team.bazar.members.entities.Member;
import com.team.bazar.users.User;

public class ListenerCreator extends MemberCreator{
    @Override
    Member createMember(User user) {
        return new Listener(user);
    }
}
