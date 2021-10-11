package io.palette.api.domain.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Roles {
    GUEST("ROLE_GUEST", "손님", 1),
    USER("ROLE_USER", "일반 사용자", 7),
    BANNED("ROLE_BANNED", "차단된 사용자", 100),
    MANAGER("ROLE_MANAGER", "관리자", 999),
    ;

    private final String key;
    private final String title;
    private final int code;
}
