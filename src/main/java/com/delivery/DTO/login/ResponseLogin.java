package com.delivery.DTO.login;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseLogin<T> {
    private T data;
    private String accessToken;
    private String refreshToken;
}
