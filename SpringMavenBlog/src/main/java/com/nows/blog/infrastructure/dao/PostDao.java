package com.nows.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nows.blog.domain.model.entity.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}
