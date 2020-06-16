package org.learn.vo;

import lombok.Data;

/**
 * 学习空间成员展示
 */
@Data
public class LearnUserVO {
    /**
     * 空间名称
     */
    private String name;

    /**
     * 学习空间id
     */
    private Long learnId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 加入时间
     */
    private String joinTime;

    /**
     * 昵称
     */
    private String username;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 成员数量
     */
    private int memberCount;
}
