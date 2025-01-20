package com.baek.basic1;


import com.baek.basic1.model.Post;
import com.baek.basic1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    private final PostService postService;

    @Autowired // 생성자 주입, @Service를 사용할 수 있게됨
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    //게시글 목록을 보여주는 페이지
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.getAllPosts()); //게시글 목록을 모델에 추가
        return "index"; //ThymeLeaf 템플릿에서 이 모데을 사용하여 게시글 목록을 표시
    }

    // 새 게시글을 추가하는 페이지
    @GetMapping("/new")
    public String newPostForm() {
        return "new-post"; // 새 게시글을 작성할 페이지로 이동
    }

    // 새 게시글을 처리하는 Post 요청
    @PostMapping("/new")
    public String addNewPost(@RequestParam String title, @RequestParam String content) {
        //새로운 게시글을 만들고 서비스에 추가
        int newId = postService.getAllPosts().stream().mapToInt(Post::getId).max().orElse(0) +1;
        Post post = new Post(newId, title, content);
        postService.addPost(post);

        return "redirect:/"; //게시글 추가 후 목록 페이지로
    }

    //게시글을 수정 폼을 보여주는 페이지
    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable("id") int id, Model model) {
        Post post = postService.getPostById(id); // Id로 게시글 찾기
        if (post != null) {
            model.addAttribute("post", post); // 게시글을 모델에 추가하여 폼으로 전달
            return "edit-post"; // 수정 페이지로 이동
        }
        return "redirect:/"; // 게시글을 찾을 수 없는 경우 목록으로 돌아감
    }


    //수정된 게시글을 저장하는 Post 요청
    @PostMapping("/edit")
    public String updatePost(@RequestParam int id, @RequestParam String title, @RequestParam String content){
        Post post= new Post(id, title, content);
        postService.updatePost(post); //서비스에서 게시글을 수정하는 메서드 호출
        return "redirect:/"; //수정 후 게시글 목록 페이지로 이동
    }

}


