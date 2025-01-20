package com.baek.basic1.service;

import com.baek.basic1.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //어노테이션, 서비스 레이어 비즈닉스 로직 처리하는 부분, 이 클래스는 스프링의 빈으로 등록, 의존성 주입 가능,
public class PostService {
    private final List<Post> posts = new ArrayList<>(); //게시글을 저장할 리스트

    //모든 게시글 반환
    public List<Post> getAllPosts() {
        return posts;
    }

    // 새로운 게시글 추가
    public void addPost(Post post) {
        posts.add(post);
    }

    // 특정 ID의 게시글 찾기
    public Post getPostById(int id) {
        if (posts == null || posts.isEmpty()) {
            return null;
        }

        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }


    // 게시글 수정
    public void updatePost(Post updatedPost){
        for (int i =0; i < posts.size(); i++){
            if(posts.get(i).getId() == updatedPost.getId()) {
                posts.set(i, updatedPost); // id가 같은 게시글을 찾아서 업데이트
                break;
            }
        }
    }

}
