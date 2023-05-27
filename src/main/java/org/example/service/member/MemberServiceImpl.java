package org.example.service.member;

import org.example.domain.member.BookMember;

import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService {
    private static long lastId = 1;
    private Map<Long, BookMember> data = new HashMap<>();

    @Override
    public BookMember read(long id) {
        return data.get(id);
    }

    @Override
    public BookMember[] readAll() {
        //TODO
        return new BookMember[0];
    }

    @Override
    public long create(BookMember member) {
        //TODO
        return 0;
    }

    @Override
    public boolean update(long id, BookMember member) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(long id) {
        //TODO
        return false;
    }
}
