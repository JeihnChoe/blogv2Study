package shop.mtcoding.blogv2.user;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.mtcoding.blogv2.user.UserRequest.JoinDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void 회원가입(JoinDTO joinDTO) {

        User user = User.builder()
                .username(joinDTO.getUsername())
                .password(joinDTO.getPassword())
                .email(joinDTO.getEmail())
                .build();

        userRepository.save(user);
    }
}
