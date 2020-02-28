package com.jojoldu.book.ojonghwa.web;

import com.jojoldu.book.ojonghwa.config.auth.LoginUser;
import com.jojoldu.book.ojonghwa.config.auth.dto.SessionUser;
import com.jojoldu.book.ojonghwa.domain.posts.PostsRepository;
import com.jojoldu.book.ojonghwa.service.PostsService;
import com.jojoldu.book.ojonghwa.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {     //p199
        model.addAttribute("posts", postsService.findAllDesc());    //p150
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");  //p190
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";         // index.mustache, p138
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";        //p139
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}