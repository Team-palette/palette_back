package io.palette.api.domain;

import io.palette.api.domain.users.Users;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "friends")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Friends {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_request_id")
    private Users friendRequest;  // 팔로우 신청을 하는 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_response_id")
    private Users friendResponse;  // 팔로우 신청을 받은 사람

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @Column(name = "accepted_at")
    private LocalDateTime acceptedAt;

    private Friends(Users friendRequest, Users friendResponse, LocalDateTime requestedAt) {
        this.friendRequest = friendRequest;
        this.friendResponse = friendResponse;
        this.requestedAt = requestedAt;
    }
}
