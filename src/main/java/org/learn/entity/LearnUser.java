package org.learn.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "learn_user")
@Entity
public class LearnUser {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "user_id", columnDefinition = "int comment '用户id'")
    private String user_id;

    @Column(name = "join_time", columnDefinition = "datetime comment '加入时间'")
    private String join_time;
}
