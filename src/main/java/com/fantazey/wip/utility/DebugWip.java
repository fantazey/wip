package com.fantazey.wip.utility;

import com.fantazey.wip.entity.Unit;
import com.fantazey.wip.repository.UnitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class DebugWip {
    private final UnitRepo repo;

    @Scheduled(fixedRate = 1000)
    private void test() {
        Unit u = Unit.builder().name("test 1").keywords(Set.of("k1", "k2", "k3", "k4")).status("None").build();
        repo.save(u);

        repo.findAll().forEach(System.out::println);
    }
}
