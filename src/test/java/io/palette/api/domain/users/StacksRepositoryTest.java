package io.palette.api.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StacksRepositoryTest {

    @Autowired
    StacksRepository stacksRepository;

    @Transactional
    @Test
    public void 기술_스택_저장하고_불러오기() throws Exception {
        // given
        Stacks stack1 = Stacks.builder()
                .stackNameEn("Spring Boot")
                .stackNameKr("스프링 부트")
                .stackColor("green")
                .build();

        Stacks stack2 = Stacks.builder()
                .stackNameEn("MyBatis")
                .build();

        stacksRepository.saveAll(List.of(stack1, stack2));
        // when

        List<Stacks> stacks = stacksRepository.findAll();

        // then
        Stacks findStacks1 = stacks.get(0);
        Stacks findStacks2 = stacks.get(1);

        Assertions.assertThat(findStacks1.getId()).isGreaterThan(0L);
        Assertions.assertThat(findStacks1.getStackNameEn()).isEqualTo("Spring Boot");
        Assertions.assertThat(findStacks1.getStackNameKr()).isEqualTo("스프링 부트");

        Assertions.assertThat(findStacks2.getId()).isGreaterThan(findStacks1.getId());
        Assertions.assertThat(findStacks2.getStackNameEn()).isEqualTo("MyBatis");
    }

    @Transactional
    @Test
    public void 같은_이름의_기술_스택이_저장되면_에러가_발생한다() throws Exception {
        // given
        Stacks stack1 = Stacks.builder()
                .stackNameEn("Spring Boot")
                .stackNameKr("스프링 부트")
                .stackColor("green")
                .build();

        Stacks stack2 = Stacks.builder()
                .stackNameEn("Spring Boot")
                .build();
        // when
        stacksRepository.save(stack1);
        // then
        org.junit.jupiter.api.Assertions.assertThrows(DataIntegrityViolationException.class, () -> stacksRepository.save(stack2));
    }

}