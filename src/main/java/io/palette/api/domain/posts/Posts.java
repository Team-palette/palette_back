package io.palette.api.domain.posts;

import io.palette.api.domain.BaseTimeEntity;
import io.palette.api.domain.users.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
// 주석
@Where(clause = "deleted = false")
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Column(name = "posts_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subTitle;
    private String content;
    private int deleted;

    // postType[0:TIL, 1:WIL, 2:자유형식]
    private int postType;
    private boolean isSecret;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = {CascadeType.ALL})
    private List<PostsComments> postsComments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = {CascadeType.ALL})
    private List<PostsLike> postsLikes = new ArrayList<>();

    @Builder
    public Posts(String title, String subTitle, String content, int deleted, int postType, boolean isSecret, Users users) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.deleted = deleted;
        this.postType = postType;
        this.isSecret = isSecret;
        this.users = users;
    }

}
