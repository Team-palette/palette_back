package io.palette.api.domain.users;

import io.palette.api.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "deleted = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users_stacks")
@Getter
@Entity
public class UsersStacks extends BaseTimeEntity {

    @Column(name = "users_stacks_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Stacks stacks;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @Builder
    public UsersStacks(Stacks stacks, Users users) {
        this.stacks = stacks;
        this.users = users;
        this.deleted = false;
    }
}
