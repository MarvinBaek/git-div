package com.baek.basic1.model;


public class Post {
    private int id; //게시글 고유 ID 저장하는 필드
    private String title; //게시글의 제목을 저장하는 필드
    private String content; //게시글의 내용을 저장하는 필드


    //생성자: Post 객체를 생성할 때 필드 값들을 초기화하는 역할
    public Post(int id, String title, String content) {
        this.id = id; //생성 시 전달받은 id 값을 필드에 저장
        this.title = title; //생성 시 전달받은 title 값을 필드에 저장
        this.content = content; //생성 시 전달받은 content 값을 필드에 저장
    }

    // getter와 setter를 사용하면 외부에서 필드에 직접 접근 x, 메서드를 통해 접근
    //id 필드의 값을 반환하는 메서스(getter)
    public int getId() {
        return id;
    }

    //ㅑid 필드의 값을 설정하는 메서드(setter)
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
