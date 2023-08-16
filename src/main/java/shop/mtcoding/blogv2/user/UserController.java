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
    public String joinForm(){
        return "/user/joinForm";
    }

    @GetMapping("/loginForm"){
    public String loginForm(){
            return "/user/loginForm";
        }
    }

        @PostMapping("/join")
        public String join(UserRequest.JoinDTO joinDTO){
//        1. 값 받아오기 //  joinDTO
//        2. 유효성검사
//
//        3. 권한검사
//
//        4. 핵심로직 호출
            userService.회원가입(joinDTO);

        return "redirect:/loginForm";
    }
}
