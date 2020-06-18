package org.learn.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;

    private String username;

    private String avatar;

    private String email;

    private Integer identity;

    private String organization;

    private String site;

    private String introduction;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", identity=" + identity +
                ", organization='" + organization + '\'' +
                ", site='" + site + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
