package com.splot.app.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {
    @Email
    private String email;
    @Size(min = 5)
    private String nickname;
    @Size(min = 8)
    private String password;
}
