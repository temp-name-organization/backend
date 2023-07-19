package kr.co.chooz.vote.entity;

import kr.co.chooz.common.entity.BaseTimeEntity;
import kr.co.chooz.user.entity.UserJpaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class VoteJpaEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaEntity postedUser;

    @BatchSize(size = 1000)
    @OneToMany(mappedBy = "vote", cascade = CascadeType.ALL)
    private List<VoteResultJpaEntity> voteResultList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "VOTE_FILTER_ID")
    private VoteFilterJpaEntity voteFilter;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "VOTE_CONTENT_ID")
    private VoteContentJpaEntity voteContent;

    private String title;

    private String detail;

    @Builder
    public VoteJpaEntity(UserJpaEntity postedUser, List<VoteResultJpaEntity> voteResultList, VoteFilterJpaEntity voteFilter, VoteContentJpaEntity voteContent, String title, String detail) {
        this.postedUser = postedUser;
        this.voteResultList = voteResultList;
        this.voteFilter = voteFilter;
        this.voteContent = voteContent;
        this.title = title;
        this.detail = detail;
    }

    public static VoteJpaEntity of(Vote vote, VoteContentJpaEntity voteContentJpaEntity, VoteFilterJpaEntity voteFilterJpaEntity, UserJpaEntity user) {
        return VoteJpaEntity.builder()
                .voteContent(voteContentJpaEntity)
                .title(vote.getTitle())
                .detail(vote.getDetail())
                .voteFilter(voteFilterJpaEntity)
                .build();
    }

}
