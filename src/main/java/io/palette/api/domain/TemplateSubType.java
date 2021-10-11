package io.palette.api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemplateSubType {

    TYPE1("타입1", 10),
    TYPE2("타입2", 20)
    ;

    private final String key;
    private final int code;
}
