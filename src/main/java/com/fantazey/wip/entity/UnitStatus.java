package com.fantazey.wip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@AllArgsConstructor
public enum UnitStatus {
    NEW(1, "new"),
    UNPACKED(2, "unpacked"),
    ASSEMBLED(3, "assembled"),
    PRIMED(4, "primed"),
    BATTLE_READY(5, "battle_ready"),
    PARADE_READY(6, "parade_ready"),
    BASE_READY(7, "base_ready"),
    DONE(0, "done");

    @Getter
    private final int id;
    @Getter
    private final String name;

    public static UnitStatus valueByName(String name) {
        return Arrays.stream(UnitStatus.values())
            .filter(u -> u.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unkown status name"));
    }
}
