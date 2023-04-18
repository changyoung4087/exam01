package org.koreait.restcontroller.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.koreait.commons.CommonException;
import org.koreait.commons.JSONResult;
import org.koreait.controllers.boards.BoardForm;
import org.koreait.models.board.Board;
import org.koreait.models.board.BoardDAO;
import org.koreait.models.board.BoardWriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Log
@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class ApiBoardController {

    private final BoardDAO boardDao;
    private final BoardWriteService service;

//    @GetMapping
//    public List<Board> boardList(){
//        List<Board> list = boardDao.gets();
//        return list;
//    }
    @GetMapping
    public ResponseEntity<JSONResult<List<Board>>> boardList(){

        List<Board> list = boardDao.gets();
        JSONResult<List<Board>> jsonResult = new JSONResult<>();
        jsonResult.setSuccess(true);
        jsonResult.setData(list);

        return ResponseEntity.ok(jsonResult);
    }

    @GetMapping("/{id}")
    public Board board(@PathVariable Long id){
        Board board = boardDao.get(id);

        return board;
    }

    @PostMapping("/write")
    public ResponseEntity<List<Board>> write(@RequestBody BoardForm boardForm){
                // @RequestBody :: application/json 방식으로 변환
        //log.info(boardForm.toString());
        boolean result = true;
        if (result) {
            throw new CommonException("게시글 등록 실패", HttpStatus.BAD_REQUEST);
        }

        service.write(boardForm);
        //List<Board> boards = boardDao.gets();

        // 응답코드 200, 400, 500
//        return ResponseEntity.status(HttpStatus.CREATED)
//                            //.body(boards); // 응답코드가 있을경우 따로 정의하여 사용.
//                            .build(); // 응답코드가 없을 경우 build 사용.. 응답코드만 출력
        return ResponseEntity.created(URI.create("/board/list")).build();
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<JSONResult<Object>> errorHandler(Exception e){
//
//        // e --> CommonException 클래스로 부터 만들어진 객체이면 - getStatus()
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 - 기본 응답코드
//        if(e instanceof CommonException){
//            CommonException commonException = (CommonException)e; // CommonException 으로 형변환
//            status = commonException.getStatus();
//        }
//        JSONResult<Object> jsonResult = new JSONResult<>();
//        jsonResult.setSuccess(false);
//        jsonResult.setMessage(e.getMessage());
//        jsonResult.setStatus(status);
//        return ResponseEntity.status(status).body(jsonResult);
//
//    }
}
