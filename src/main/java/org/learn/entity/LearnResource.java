package org.learn.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "learn_resource")
@Entity
public class LearnResource {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "resource_name", columnDefinition = "varchar(100) comment '资源名称'")
    private String resourceName;

    @Column(name = "user_name", columnDefinition = "char(50) comment '作者'")
    private String userName;

    @Column(name = "introduction", columnDefinition = "varchar(255) comment '描述'")
    private String introduction;

    @Column(name = "content", columnDefinition = "text comment '内容'")
    private String content;

    @Column(name = "file_url", columnDefinition = "text comment '资源文件路径'")
    private String fileUrl;

    @Column(name = "tags", columnDefinition = "char(50) comment '标签'")
    private String tags;

    @Column(name = "type", columnDefinition = "tinyint comment '资源类型'")
    private Integer type;

    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'")
    private String updateTime;
}
