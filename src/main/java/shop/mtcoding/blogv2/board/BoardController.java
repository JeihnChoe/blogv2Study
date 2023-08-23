package shop.mtcoding.blogv2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.blogv2.user.UserRepository;

@Controller
public class BoardController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardService boardService;

    @GetMapping("/board/saveForm")
    public String saveForm() {

        return "/board/saveForm";
    }

    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO) {


        boardService.글쓰기(saveDTO);

        return "redirect:/";
    }
}
