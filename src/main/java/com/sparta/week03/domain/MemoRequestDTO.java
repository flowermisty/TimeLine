package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemoRequestDTO {
    private final String username;
    private final String contents;

}
