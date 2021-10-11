package io.palette.api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemplateType {
    TIL("틸", 100),
    WIL("윌", 200)
    ;

    private final String key;
    private final int code;
}
