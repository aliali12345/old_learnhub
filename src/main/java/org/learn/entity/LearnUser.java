package org.learn.entity;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Table(name = "learn_user")
@Entity
public class LearnUser {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NonNull
    @Column(name = "learn_id", columnDefinition = "bigint comment '学习空间id'")
    private Long learnId;

    @NonNull
    @Column(name = "user_id", columnDefinition = "bigint comment '用户id'")
    private String userId;

    @Column(name = "join_time", columnDefinition = "datetime comment '加入时间'")
    private String joinTime;
}
