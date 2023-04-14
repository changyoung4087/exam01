package org.koreait.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc // 스프링 공식 api 에 나와있는 클래스
public class BoardWriteTest {

    @Autowired
    private MockMvc mockMvc;

    @Test @DisplayName("게시글 작성 성공 시 /board/list 로 이동")
    public void writeSuccessTest() throws Exception {
        mockMvc.perform(post("/board/write")
                .param("subject", "제목2")
                .param("content", "내용2"))
                .andDo(print())
                .andExpect(redirectedUrl("/board/list"));
    }

    // 통합테스트(모든 소스를 구현한 뒤 통합테스트로 패스여부확인)
    @Test @DisplayName("제목, 내용 필수 체크")
    public void validationTest1() throws Exception {
        String body = mockMvc.perform(post("/board/write"))
                                //.andDo(print()) // 데이터 확인
                                //.andExpect(status().isOk()); // 모든 소스가 정상작동하는지 확인
                                .andReturn().getResponse().getContentAsString();
        // 제목 유효성 검사 체크
        assertTrue(body.contains("제목을 입력하세요."));

        // 내용 유효성 검사 체크
        assertTrue(body.contains("내용을 입력하세요."));
    }
}
