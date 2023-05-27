package org.example.service.member;

import org.example.domain.member.BookMember;

public interface MemberService {
    BookMember read(long id);

    BookMember[] readAll();

    long create(BookMember member);

    boolean update(long id, BookMember member);

    boolean delete(long id);
}
