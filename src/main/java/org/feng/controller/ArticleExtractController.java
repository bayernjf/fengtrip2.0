package org.feng.controller;

import org.feng.bean.dto.ExtractWordsDTO;
import org.feng.bean.dto.ExtractWordsParameterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiangfeng-20240723
 * @time 2024-07-23 00:09
 */
@RestController
@RequestMapping("/article/extract")
public class ArticleExtractController {

    @PostMapping("/extractWords")
    public List<ExtractWordsDTO> extractWords(ExtractWordsParameterDTO extractWordsParameterDTO) {
        // ExtractWordsPO mapper方法返回对象，和数据库记录对应
        return null;
    }
}
