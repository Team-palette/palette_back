package io.palette.api.domain.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class UsersStacksRepositoryTest {
    @Autowired
    StacksRepository stacksRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersStacksRepository usersStacksRepository;

    @Test
    public void 유저와_연결된_스택을_저장_조회한다() throws Exception {
        // given

        // when

        // then
    }
}