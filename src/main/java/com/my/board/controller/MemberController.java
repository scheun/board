package com.my.board.controller;

import com.my.board.model.Member;
import com.my.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/member/login")
    public String login(@CookieValue(required = false) String id, Model model) {

        if (id != null) model.addAttribute("id", id);

        return "member/login";
    }

    @GetMapping("/member/join")
    public String join() {
        return "member/join";
    }

    @GetMapping("/member/findId")
    public String findIdView() {
        return "member/findId";
    }

    @GetMapping("/member/findPwd")
    public String findPwd() {
        return "member/findPwd";
    }


    @PostMapping("/join")
    @ResponseBody
    public int join(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getPwd());
        member.setPwd(encodedPassword);

        return memberService.joinMember(member);
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(String id) {
        int cnt = memberService.idCheck(id);
        return cnt;
    }

    @PostMapping("/member/login")
    public String loginMembers(String id, String pwd, HttpSession session, String rememberId, HttpServletResponse response, Model model) {
        String encodedPwd = memberService.pwdCheck(id);

        if (passwordEncoder.matches(pwd, encodedPwd)) {
            session.setAttribute("id", id);

            if (rememberId != null) {
                Cookie cookie = new Cookie("id", id);
                cookie.setMaxAge(10*60);
                response.addCookie(cookie);
                model.addAttribute("cookieId", id);
            }

            return "redirect:/";
        } else {
            model.addAttribute("msg", "???????????? ??????????????? ???????????????.");
            return "member/login";
        }
    }

    @GetMapping("/member/logout")
    public String logoutMembers(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }


    @ResponseBody
    @RequestMapping(value = "/member/findId", method = { RequestMethod.POST })
    public String findId(String email) {
        return memberService.findId(email) == null? ( "?????? ???????????? ???????????? ???????????? ????????????." ) :  ( "???????????? " + memberService.findId(email) + "?????????." );
    }

    @ResponseBody
    @RequestMapping(value = "/member/findPwd", method = { RequestMethod.POST })
    public int findPwd(String email, String id) {
        return memberService.findPwd(id, email);
    }

    @PostMapping("/updatePwd")
    @ResponseBody
    public void updatePwd(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getPwd());
        member.setPwd(encodedPassword);

        memberService.updatePwd(member);
    }
}
