
package io.palette.api.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;
    
    @Transactional
    @Test
    public void 유저_저장_불러오기_성공() throws Exception {
        // given
        Users user1 = Users.builder()
                .loginId("test1")
                .password("1234")
                .email("email1@email.com")
                .nickname("nickname1")
                .build();

        Users user2 = Users.builder()
                .loginId("test2")
                .password("1234")
                .email("email2@email.com")
                .nickname("nickname2")
                .build();

        usersRepository.saveAll(List.of(user1, user2));

        LocalDateTime now = LocalDateTime.now();

        // when
        List<Users> users = usersRepository.findAll();

        // then
        Users findUser1 = users.get(0);
        Users findUser2 = users.get(1);

        Assertions.assertThat(findUser1.getId()).isGreaterThan(0L);
        Assertions.assertThat(findUser1.getLoginId()).isEqualTo(user1.getLoginId());
        Assertions.assertThat(findUser1.getEmail()).isEqualTo(user1.getEmail());
        Assertions.assertThat(findUser1.isDeleted()).isFalse();
        Assertions.assertThat(findUser1.isEmailVerified()).isFalse();
        Assertions.assertThat(findUser1.getCreatedAt()).isEqualToIgnoringSeconds(now);
        Assertions.assertThat(findUser1.getModifiedAt()).isEqualToIgnoringSeconds(now);


        Assertions.assertThat(findUser2.getId()).isGreaterThan(findUser1.getId());
        Assertions.assertThat(findUser2.getLoginId()).isEqualTo(user2.getLoginId());
        Assertions.assertThat(findUser2.getEmail()).isEqualTo(user2.getEmail());
        Assertions.assertThat(findUser2.isDeleted()).isFalse();
        Assertions.assertThat(findUser2.isEmailVerified()).isFalse();
        Assertions.assertThat(findUser2.isProfilePrivacy()).isFalse();
        Assertions.assertThat(findUser2.getGithubDomain()).isNull();
        Assertions.assertThat(findUser2.getCreatedAt()).isEqualToIgnoringSeconds(now);
        Assertions.assertThat(findUser2.getModifiedAt()).isEqualToIgnoringSeconds(now);


    }

    @Transactional
    @Test
    public void 유니크한_정보에_대해_중복이_발생하면_에러가_발생한다() throws Exception {
        // given

        List<Users> users = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            int t = (i + 1) % 5;
            Users user = Users.builder()
                    .loginId("test" + t)
                    .password("1234")
                    .email("email" + t + "@email.com")
                    .nickname("nickname" + t)
                    .build();

            users.add(user);
        }

        // when
        usersRepository.saveAll(users.subList(0, 5));

        // then
        org.junit.jupiter.api.Assertions.assertThrows(DataIntegrityViolationException.class, () -> usersRepository.save(users.get(5)));
        org.junit.jupiter.api.Assertions.assertThrows(DataIntegrityViolationException.class, () -> usersRepository.save(users.get(6)));
        org.junit.jupiter.api.Assertions.assertThrows(DataIntegrityViolationException.class, () -> usersRepository.save(users.get(7)));
        org.junit.jupiter.api.Assertions.assertThrows(DataIntegrityViolationException.class, () -> usersRepository.save(users.get(8)));
        org.junit.jupiter.api.Assertions.assertThrows(DataIntegrityViolationException.class, () -> usersRepository.save(users.get(9)));
    }

}