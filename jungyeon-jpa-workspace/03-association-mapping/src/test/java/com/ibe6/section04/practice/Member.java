package com.ibe6.section04.practice;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity(name = "member")
@Table(name = "tbl_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "member_name")
    private String memberName;

    @ManyToOne(
            fetch = FetchType.EAGER // 멤버조회시 팀정보 즉시 조회
            , cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(
            fetch = FetchType.LAZY // 멤버조회시 라커에 대한 정보 조회를 즉시 수행 x => 사용할때 꺼내겠당(조회)!
            , cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "locker_id")
    private Locker locker;
}
