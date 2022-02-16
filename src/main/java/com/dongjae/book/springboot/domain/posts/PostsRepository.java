package com.dongjae.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /* 상속시 자동으로 crud 메소드 자동 생성 */
}
