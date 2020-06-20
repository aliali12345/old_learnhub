package org.learn.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class LearnhubAddVO {
    private String name;
    private String introduction;
    private MultipartFile file;
}
