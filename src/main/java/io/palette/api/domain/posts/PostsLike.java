package io.palette.api.domain.posts;

import io.palette.api.domain.BaseTimeEntity;
import io.palette.api.domain.users.Users;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Where(clause = "deleted = false")
@Table(name = "posts_like")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PostsLike extends BaseTimeEntity {

    @Column(name = "posts_like_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Posts posts;

    @Builder
    public PostsLike(Users users, Posts posts) {
        this.users = users;
        this.posts = posts;
    }
}
