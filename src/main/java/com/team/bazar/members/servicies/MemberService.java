package com.team.bazar.members.servicies;

import com.team.bazar.members.entities.Listener;
import com.team.bazar.members.entities.Member;
import com.team.bazar.members.repositories.ListenerRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final ListenerRepository listenerRepository;

    public MemberService(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    public void save(Listener listener){
        listenerRepository.save( listener);
    }
}
