package io.palette.api.domain.users;

import io.palette.api.domain.BaseTimeEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Where(clause = "deleted = false")
@Table(name = "palettes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Palettes extends BaseTimeEntity {

    @Column(name = "palettes_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // postType[0:TIL, 1:WIL]
    private int postType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;

    @Builder
    public Palettes(int postType, Users users){
        this.postType = postType;
        this.users = users;
    }

}
