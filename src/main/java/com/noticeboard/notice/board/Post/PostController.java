package com.noticeboard.notice.board.Post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostRepository postRepository;

    @RequestMapping("/")
    public String test(Model model){
        List<Post> postList = this.postRepository.findAll();
        System.out.println(postList);
        model.addAttribute("postList", postList);
        model.addAttribute("targetPost", postList.get(0));
        return "main";
    }

    @PostMapping("/write")
    public String write(){
        Post post = new Post();
        post.setTitle("aaa");
        post.setContent("");
        post.setCreateData(LocalDateTime.now());

        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        Post post = postRepository.findById(id).get(); //58
        model.addAttribute("targetPost", post);
        model.addAttribute("postList", postRepository.findAll());
        return "main";
    }

    @PostMapping("/update")
    public String update(Long id, String title, String content){
        Post post = postRepository.findById(id).get();
        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);
        return "redirect:/detail/" + id;
    }
}

