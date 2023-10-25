package com.noticeboard.notice.board;

import com.noticeboard.notice.board.Post.Post;
import com.noticeboard.notice.board.Post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class NoticeBoardApplicationTests {
	@Autowired
	private PostRepository postRepository;


	@Test
	void contextLoads() {
		Post p1 = new Post();
		p1.setTitle("aaa");
		p1.setContent("bbb");
		p1.setCreateData(LocalDateTime.now());
		this.postRepository.save(p1);


	}

}
