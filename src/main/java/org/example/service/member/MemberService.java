package org.example.service.member;

import java.lang.reflect.Member;

public interface MemberService {
    Member read(long id);

    Member[] readAll();

    long create(Member member);

    boolean update(long id, Member member);

    boolean delete(long id);
}
