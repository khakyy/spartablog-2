package com.sparta.myblog.service;

import com.sparta.myblog.dto.ContentRequestDto;
import com.sparta.myblog.entity.Content;
import com.sparta.myblog.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    @Transactional
    public Content createContent(ContentRequestDto requestDto) {
        Content content = new Content(requestDto);
        contentRepository.save(content);
        return content;
    }

    @Transactional(readOnly = true)
    public List<Content> getContents() {
        return contentRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, String password, ContentRequestDto requestDto) {
        Content content = contentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        content.update(requestDto);
        return content.getId();
    }

    @Transactional
    public Long deleteContent(Long id, String password) {
        contentRepository.deleteById(id);
        return id;
    }
}
