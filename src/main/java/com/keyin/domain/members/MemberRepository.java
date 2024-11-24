package com.keyin.domain.members;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findMemberByName(String memberName);

    Optional<Member> findMemberByMembership(String membershipType);

    Optional<Member> findMemberByPhoneNumber(String phoneNumber);

    Iterable<Member> findMemberByTournyID(Long tournamentId);
}
