package shop.mtcoding.blogv2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {

        User user = User.builder()
                .username(joinDTO.getUsername())
                .password(joinDTO.getPassword())
                .email(joinDTO.getEmail())
                .build();

        userRepository.save(user);
    }

    public User 로그인(UserRequest.LoginDTO loginDTO) {

        User user = userRepository.findByUsername(loginDTO.getUsername());

        // 1. 유저네임 검증
        if (user == null) {
            return null;
        }

        // 2. 패스워드 검증
        if (user.getPassword() != loginDTO.getPassword()) {
            return null;
        }

        // 3. 로그인 성공
        return user;
    }
}
