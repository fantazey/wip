package com.fantazey.wip.service;

import com.fantazey.wip.repository.WorkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorkService {
    private final WorkRepo workRepo;
}
