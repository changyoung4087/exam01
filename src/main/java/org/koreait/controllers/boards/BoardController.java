package org.koreait.controllers.boards;

import jakarta.validation.Valid;
import org.koreait.models.board.BoardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardWriteService service;
    @GetMapping("/write")
    public String write(Model model){
        BoardForm boardForm = new BoardForm();
        model.addAttribute("boardForm", boardForm);

        boolean a = false;
        if(a != true){
            throw  new RuntimeException("에러메시지 출력");
        }
        return "board/write";
    }
    @PostMapping("/write")
    public String writePs(@Valid BoardForm boardForm, Errors errors){
        if(errors.hasErrors()){ // 에러가 있으면 화면이 넘어가지 않음.
            return "board/write";
        }

        service.write(boardForm);

        return "redirect:/board/list";
    }
}
