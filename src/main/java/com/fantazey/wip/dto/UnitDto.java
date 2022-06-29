package com.fantazey.wip.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
public class UnitDto {
    private String name;
    private Set<String> keywords;
    private Integer progress;
    private OffsetDateTime dateAdd;
    private String status;
}
