package com.fantazey.wip.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Work {
    @Id
    @GeneratedValue
    private long id;

    private String title;

    private OffsetDateTime date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "unit_works",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name="unit_id"))
    private List<Unit> units;
}
