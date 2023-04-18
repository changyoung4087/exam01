package org.koreait.controllers.boards;

import lombok.RequiredArgsConstructor;
import org.koreait.models.board.Board;
import org.koreait.models.board.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BoardListController {

    private final BoardDAO boardDao;
    @ResponseBody // 반환값 객체를 반환
    @GetMapping("/ap2/board/{id}")
    public Board board(@PathVariable Long id){
        Board board = boardDao.get(id);

        return board;
    }
}
