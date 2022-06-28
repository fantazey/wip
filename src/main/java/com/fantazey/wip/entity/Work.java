package com.fantazey.wip.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.OffsetDateTime;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Work {
    @Id
    @GeneratedValue
    private long id;

    private OffsetDateTime date;

    @ManyToMany
    private List<Unit> units;
}
