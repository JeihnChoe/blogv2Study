package shop.mtcoding.blogv2.user;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Getter
    @Setter
    class JoinDTO {
        private String username;
        private String password;
        private String email;
    }

    @Getter
    @Setter
    public class LoginDTO {
        private String username;
        private String password;
    }
}
