package org.learn.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
     * 成员数量
     */
    private int memberCount;

    /**
     * 成员信息
     */
    private List<UserInfo> userInfos = new ArrayList<>();

    @Data
    public static class UserInfo{

        /**
         * 用户id
         */
        private Long userId;

        /**
         * 昵称
         */
        private String username;

        /**
         * 头像
         */
        private String avatar;

        /**
         * 加入时间
         */
        private String joinTime;
    }
}
