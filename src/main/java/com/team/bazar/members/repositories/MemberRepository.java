package com.team.bazar.members.repositories;

import com.team.bazar.members.entities.Listener;
import com.team.bazar.members.entities.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@NoRepositoryBean
public interface MemberRepository<T extends Member> extends CrudRepository<T, UUID> {




}
