package com.fantazey.wip.utility;

import com.fantazey.wip.entity.Unit;
import com.fantazey.wip.repository.UnitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DebugWip {
    private final UnitRepo repo;

    @PostConstruct
    private void test() {
        for (int i =0; i< 10; i++){
            Unit u = Unit.builder()
                    .name("test 1")
                    .dateAdd(OffsetDateTime.now())
                    .keywords(Set.of("k1", "k2", "k3", "k4"))
                    .status("None")
                    .build();
            repo.save(u);
        }
        repo.findAll().forEach(System.out::println);
    }
}
