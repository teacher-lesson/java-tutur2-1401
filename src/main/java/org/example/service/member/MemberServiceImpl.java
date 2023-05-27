package org.example.service.member;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService {
    private static long lastId = 1;
    private Map<Long, Member> data = new HashMap<>();

    @Override
    public Member read(long id) {
        return data.get(id);
    }

    @Override
    public Member[] readAll() {
        //TODO
        return new Member[0];
    }

    @Override
    public long create(Member member) {
        //TODO
        return 0;
    }

    @Override
    public boolean update(long id, Member member) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(long id) {
        //TODO
        return false;
    }
}
