package shop.mtcoding.blogv2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.blogv2._core.util.Script;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm() {

        return "/user/loginForm";
    }

    @PostMapping("/login")
    public @ResponseBody String login(UserRequest.LoginDTO loginDTO) {

        User sessionUser = userService.로그인(loginDTO);

        if (sessionUser == null) {
            return Script.back("로그인 실패");
        }

        session.setAttribute("sessionUser", sessionUser);
        return Script.href("/");
    }


    @GetMapping("/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO) {
//        1. 값 받아오기 //  joinDTO
//        2. 핵심로직 호출

        userService.회원가입(joinDTO);

        return "redirect:/loginForm";

    }


}
