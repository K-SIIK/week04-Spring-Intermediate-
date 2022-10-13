package com.sparta.assginment04.service;

import com.sparta.assginment04.dto.UserDto;
import com.sparta.assginment04.model.User;
import com.sparta.assginment04.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    // 비밀번호 인코딩해주는 spring security 내의 라이브러리 의존성 주입
    private final PasswordEncoder passwordEncoder;

    public User signupUser(UserDto.Signup signupDto) {
        String nickName = signupDto.getNickName();
        String password = signupDto.getPassword();
        String passwordAgain = signupDto.getPasswordAgain();

        // 중복된 아이디가 있는지 체크
        Optional<User> found = userRepository.findByNickName(nickName);
        if (found.isPresent())
            throw new IllegalArgumentException("중복된 계정입니다.");

        // 비밀번호 서로 같은지 확인
        if (!passwordAgain.equals(password))
            throw new IllegalArgumentException("비밀 번호가 다릅니다.");

        // 정규식 나중에!~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        // Response 나중에!!!!!!!!!!!!!!!!!!!!
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(nickName, encodedPassword);
        userRepository.save(user);

        return user;
    }
}
