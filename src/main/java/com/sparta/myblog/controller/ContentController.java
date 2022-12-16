package com.sparta.myblog.controller;

import com.sparta.myblog.dto.ContentRequestDto;
import com.sparta.myblog.entity.Content;
import com.sparta.myblog.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/api/post")
    public Content createContent(@RequestBody ContentRequestDto requestDto) {
        return contentService.createContent(requestDto);
    }

    @GetMapping("/api/get")
    public List<Content> getContents() {
        return contentService.getContents();
    }

    @PutMapping("/api/put/{id}{password}")
    public Long updateContent(@PathVariable Long id, @PathVariable String password, @RequestBody ContentRequestDto requestDto) {
        return contentService.update(id, password, requestDto);
    }


    @DeleteMapping("/api/delete/{id}{password}")
    public Long deleteContent(@PathVariable Long id, @PathVariable String password) {
        return contentService.deleteContent(id, password);
    }
}
