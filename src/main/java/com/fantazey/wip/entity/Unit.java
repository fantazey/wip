package com.fantazey.wip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Unit {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="unit_keywords", joinColumns = @JoinColumn(name="unit_id"))
    private Set<String> keywords;
    private OffsetDateTime dateAdd;
    private OffsetDateTime dateDone;
    private String status;
    private int progress;

    @ManyToMany(fetch=FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "unit_works",
            joinColumns = @JoinColumn(name = "unit_id"),
            inverseJoinColumns = @JoinColumn(name = "work_id"))
    private List<Work> workRecords;
}
