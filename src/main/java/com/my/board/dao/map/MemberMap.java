package com.my.board.dao.map;

import com.my.board.model.Member;

public interface MemberMap {
    int joinMember(Member member);
    int idCheck(String id);
    String pwdCheck(String id);
    Member login(String id, String pwd);
    String findId(String email);
    int findPwd(String id, String email);
    void updatePwd(Member member);
}
