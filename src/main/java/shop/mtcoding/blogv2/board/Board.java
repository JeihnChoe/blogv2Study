package shop.mtcoding.blogv2.board;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.blogv2.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@Table(name = "board_tb")
@Entity // ddl-auto가 create
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = true, length = 10000)
    private String content;

    @ManyToOne
    private User user;

    private Timestamp createdAt;
}