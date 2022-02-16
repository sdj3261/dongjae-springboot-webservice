package com.dongjae.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest // 설정하지 않을 경우 기본데이터 인메모리 h2 db
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit 단위 테스트 후 바로 수행 Insert,update 후 테스트용 db 초기화
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "신동재";

        // 테이블에서 insert/update 쿼리 실행 , id값이 있다면 update 없다면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        //when
        // 테이블 posts에 있는 모든 데이터 조회하여 가져온다
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }
}
