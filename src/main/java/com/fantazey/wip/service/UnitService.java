package com.fantazey.wip.service;

import com.fantazey.wip.repository.UnitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UnitService {
    private final UnitRepo unitRepo;
}
