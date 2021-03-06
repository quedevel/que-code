package org.quecode.backoffice.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USERNAME_OR_PASSWORD_NOT_FOUND_EXCEPTION(400,"아이디 또는 비밀번호가 일치하지 않습니다.",HttpStatus.BAD_REQUEST),
    FORBIDDEN_EXCEPTION(403,"해당 요청에 대한 권한이 없습니다.",HttpStatus.FORBIDDEN),
    UNAUTHORIZED_EXCEPTION(401,"로그인 후 이용가능합니다.",HttpStatus.UNAUTHORIZED),
    EXPIRED_JWT_EXCEPTION(444,"기존 토큰이 만료되었습니다. 해당 토큰을 가지고 get-newtoken링크로 이동해주세요.",HttpStatus.UNAUTHORIZED),
    RELOGIN(445,"모든 토큰이 만료되었습니다. 다시 로그인해주세요.",HttpStatus.UNAUTHORIZED);

    private int code;

    private String message;

    private HttpStatus httpStatus;
}
