package com.keyin.domain.members;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findMemberByMemberName(String memberName);

    Optional<Member> findMemberByMembershipType(String membershipType);

    Optional<Member> findMemberByPhoneNumber(String phoneNumber);

//    List<Member> findMemberByTournamentStartDate(String startDate);
}
