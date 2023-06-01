package com.team.bazar.members.factories;

import com.team.bazar.members.entities.Member;
import com.team.bazar.users.User;

public abstract class MemberCreator {

    abstract Member createMember(User user);

    public Member makeMember(User user){
        return createMember(user);
    }


}
