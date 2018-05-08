package com.article.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    public List<Article> findByClassify(String classify);
}
