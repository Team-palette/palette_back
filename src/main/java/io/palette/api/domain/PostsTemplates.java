package io.palette.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "posts_templates")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PostsTemplates {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "template_type", nullable = false)
    private TemplateType templateType;

    @Enumerated(EnumType.STRING)
    @Column(name = "template_sub_type", nullable = true)
    private TemplateSubType templateSubType;

    @Column(name = "template_title", nullable = false, unique = true)
    private String templateTitle;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "used", nullable = false)
    private boolean used;

    @Builder
    public PostsTemplates(TemplateType templateType, TemplateSubType templateSubType, String templateTitle, String contents, boolean used) {
        this.templateType = templateType;
        this.templateSubType = templateSubType;
        this.templateTitle = templateTitle;
        this.contents = contents;
        this.used = used;
    }
}
