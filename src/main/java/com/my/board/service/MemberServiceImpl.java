package com.my.board.service;

import com.my.board.dao.map.MemberMap;
import com.my.board.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMap memberMap;

    @Override
    public int joinMember(Member member) {
        return memberMap.joinMember(member);
    }

    @Override
    public int idCheck(String id) {
        return memberMap.idCheck(id);
    }

    @Override
    public String pwdCheck(String id) {
        return memberMap.pwdCheck(id);
    }

    @Override
    public Member login(String id, String pwd) {
        return memberMap.login(id, pwd);
    }

    @Override
    public String findId(String email) {
        return memberMap.findId(email);
    }

    @Override
    public int findPwd(String id, String email) {
        return memberMap.findPwd(id, email);
    }

    @Override
    public void updatePwd(Member member) {
        memberMap.updatePwd(member);
    }
}
