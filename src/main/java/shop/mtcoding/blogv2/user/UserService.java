package shop.mtcoding.blogv2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.mtcoding.blogv2.user.UserRequest.JoinDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void 회원가입(JoinDTO joinDTO) {
        System.out.println("테스트 : 2");
        User user = User.builder()
                .username(joinDTO.getUsername())
                .password(joinDTO.getPassword())
                .email(joinDTO.getEmail())
                .build();

        userRepository.save(user);
        System.out.println("테스트 : 3");
    }


    public void 로그인() {


    }
}
