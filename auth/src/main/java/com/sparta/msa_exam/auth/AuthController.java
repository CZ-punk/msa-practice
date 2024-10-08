package com.sparta.msa_exam.auth;

import com.sparta.msa_exam.auth.dto.SigninDto;
import com.sparta.msa_exam.auth.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signup(@RequestBody SignupDto requestDto) {
        authService.signup(requestDto.getUsername(), requestDto.getPassword());
        return ResponseEntity.ok(requestDto);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signin(@RequestBody SigninDto requestDto) {
        String token = authService.signin(requestDto.getUsername(), requestDto.getPassword());
        return ResponseEntity.ok(token);
    }

}
