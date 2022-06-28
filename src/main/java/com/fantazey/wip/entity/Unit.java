package com.fantazey.wip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.time.OffsetDateTime;
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
}
