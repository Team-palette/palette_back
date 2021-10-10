package io.palette.api.domain.users;

import io.palette.api.domain.BaseTimeEntity;
import io.palette.api.domain.posts.Posts;
import io.palette.api.domain.posts.PostsLike;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Where(clause = "deleted = false")
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Users extends BaseTimeEntity {
    @Column(name = "users_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "login_id", nullable = false, unique = true)
    private String loginId;
    @Column(length = 500, name = "password", nullable = false)
    private String password;
    @Column(length = 100, name = "email", nullable = false, unique = true)
    private String email;
    @Column(length = 100, name = "nickname", nullable = false, unique = true)
    private String nickname;

    private String imageUrl;
    private String thumbnailUrl;
    private String originalFileName;
    private String fileExtension;
    private boolean emailVerified;
    private String provider;
    private String providerId;
    private String emailVerifiedToken;
    private LocalDateTime emailVerifiedTokenCreatedAt;

    @Enumerated(EnumType.STRING)
    private Roles roles;
    private String bio;
    private String githubDomain;
    private String organization;
    private boolean profilePrivacy;
    private boolean postPrivacy;
    private boolean palettePrivacy;
    private LocalDateTime lastEmailSend;

    @Column(name = "deleted")
    private boolean deleted;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = {CascadeType.ALL})
    private List<UsersStacks> usersStacksList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = {CascadeType.ALL})
    private List<Palettes> palettes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = {CascadeType.ALL})
    private List<Posts> posts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = {CascadeType.ALL})
    private List<PostsLike> postsLikes = new ArrayList<>();

    @Builder
    public Users (String loginId, String password, String email, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;

        this.emailVerified = false;
        this.deleted = false;
    }

}