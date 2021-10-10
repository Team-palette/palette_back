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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Where(clause = "deleted = false")
@Table(name = "posts_comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PostsComments extends BaseTimeEntity {

    @Column(name = "posts_comments_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private boolean deleted;
    private int parentId;
    // commentStatus[0:로그인한 유저의 댓글, 1:로그인하지 않은 유저의 댓글]
    private int commentStatus;
    private String virtureId;
    private String virturePwd;
    private String userid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Posts posts;

    @Builder PostsComments(String content, boolean deleted, int parentId, int commentStatus, String virtureId, String virturePwd, String userid){
        this.content = content;
        this.deleted = deleted;
        this.parentId = parentId;
        this.commentStatus = commentStatus;
        this.virtureId = virtureId;
        this.virturePwd = virturePwd;
        this.userid = userid;
    }
}
