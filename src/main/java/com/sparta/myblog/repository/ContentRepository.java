package com.sparta.myblog.repository;

import com.sparta.myblog.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findAllByOrderByModifiedAtDesc();
}
