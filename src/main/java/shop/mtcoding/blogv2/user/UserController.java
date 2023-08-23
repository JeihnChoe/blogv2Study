package shop.mtcoding.blogv2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO) {
//        1. 값 받아오기 //  joinDTO
//        2. 핵심로직 호출
        try {
            userService.회원가입(joinDTO);
        } catch (Exception e) {
            return "redirect:/loginForm";
        }

        System.out.println("테스트 : 1");
        return "/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String login() {


        return "redirect:/";
    }


}
