package com.fantazey.wip.utility;

import com.fantazey.wip.dto.UnitDto;
import com.fantazey.wip.entity.Unit;
import com.fantazey.wip.entity.UnitStatus;
import com.fantazey.wip.repository.UnitRepo;
import com.fantazey.wip.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DebugWip {
    private final UnitService unitService;
    private final UnitRepo unitRepo;

    @PostConstruct
    private void test() {
        long count = unitRepo.count();
        if (count > 0) {
            return;
        }
        UnitDto d1 = UnitDto.builder().name("demo unit 1").progress(0).keywords(Set.of("keyword A", "keyword B")).status(UnitStatus.NEW.getName()).build();
        unitService.createUnit(d1);
        UnitDto d2 = UnitDto.builder().name("demo unit 2").progress(20).keywords(Set.of("keyword A1", "keyword 1B23")).status(UnitStatus.PRIMED.getName()).build();
        unitService.createUnit(d2);
        UnitDto d3 = UnitDto.builder().name("demo unit 3").progress(50).keywords(Set.of("keyword ZAZA", "keyword GAGA")).status(UnitStatus.BASE_READY.getName()).build();
        unitService.createUnit(d3);
        UnitDto d4 = UnitDto.builder().name("demo unit 4").progress(90).keywords(Set.of("keyword DD", "keyword DA")).status(UnitStatus.PARADE_READY.getName()).build();
        unitService.createUnit(d4);
        UnitDto d5 = UnitDto.builder().name("demo unit 5").keywords(Set.of("keyword AWA", "keyword BWA")).build();
        unitService.createUnit(d5);
        unitRepo.findAll().forEach(System.out::println);
    }
}
