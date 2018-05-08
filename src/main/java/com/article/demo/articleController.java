package com.article.demo;


import org.hibernate.sql.OracleJoinFragment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.soap.Text;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class articleController {

    @Autowired
    private ArticleRepository articleRepository;

    @CrossOrigin
    @PostMapping(value = "articleLists")
    public Map<String, Object> articleLists() {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", articleRepository.findAll());
        return map;
    }

    @CrossOrigin
    @PostMapping(value = "addArticle")
    @ResponseBody
    public  Map<String, Object> addArticle(@RequestBody Article article) {

        System.out.println(article.getTitle());
        articleRepository.save(article);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "成功");
        return map;
    }

    @CrossOrigin
    @GetMapping(value = "/deleteArticle/{id}")
    public Map<String, Object> deleteArticle(@PathVariable("id") Integer id) {
        articleRepository.delete(articleRepository.findById(id).orElse(null));
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "成功");
        return map;
    }

    @CrossOrigin
    @GetMapping(value = "/articleFind/{id}")
    public Map<String, Object> articleFind(@PathVariable("id") Integer id) {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", articleRepository.findById(id).orElse(null));
        return map;
    }

    @CrossOrigin
    @PostMapping(value = "/articleUpdate")
    @ResponseBody
    public Map<String, Object> articleUpdate(@RequestBody Article article) {

        articleRepository.save(article);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "成功");
        return map;
    }

    @CrossOrigin
    @PostMapping(value = "/findByClassify")
    @ResponseBody
    public Map<String, Object> findByClassify(@RequestBody Article article) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", articleRepository.findByClassify(article.getClassify()));
        return map;
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, Object> map) {
        Map<String, Object> resmap = new HashMap<>();
        if (map.get("username").toString().equals("lwh") && map.get("password").toString().equals("123456")) {
            resmap.put("code", 1);
            resmap.put("message", "成功");
        } else {
            resmap.put("code", 0);
            resmap.put("message", "用户名或密码错误");
        }
        return resmap;
    }
}
