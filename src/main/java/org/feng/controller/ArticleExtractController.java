package org.feng.controller;

import org.feng.dto.ExtractWordsDTO;
import org.feng.dto.ExtractWordsParameterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangfeng-20240723
 * @time 2024-07-23 00:09
 */
@RestController
@RequestMapping("/article/extract")
public class ArticleExtractController {

    @PostMapping("/extractWords")
    public List<ExtractWordsDTO> extractWords(@RequestBody ExtractWordsParameterDTO extractWordsParameterDTO) {
        String content = extractWordsParameterDTO.getContent();
        System.out.println(content);
        // ExtractWordsPO mapper方法返回对象，和数据库记录对应
        List<ExtractWordsDTO> result = new ArrayList<>();
        ExtractWordsDTO extractWordsDTO = new ExtractWordsDTO();
        extractWordsDTO.setResult("jiangfeng is 国王");
        result.add(extractWordsDTO);
        return result;
    }
}
