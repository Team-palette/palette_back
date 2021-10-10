package io.palette.api.domain.users;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "stacks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Stacks {
    @Id
    @Column(name = "stacks_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "stack_name_en", nullable = false, unique = true)
    private String stackNameEn;

    @Column(length = 50, name = "stack_name_kr")
    private String stackNameKr;

    @Column(length = 50, name = "stack_color")
    private String stackColor;

    @Builder
    public Stacks(String stackNameEn, String stackNameKr, String stackColor) {
        this.stackNameEn = stackNameEn;
        this.stackNameKr = stackNameKr;
        this.stackColor = stackColor;
    }
}
