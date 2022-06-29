package com.fantazey.wip.service;

import com.fantazey.wip.dto.UnitDto;
import com.fantazey.wip.entity.Unit;
import com.fantazey.wip.entity.UnitStatus;
import com.fantazey.wip.exception.NotFoundException;
import com.fantazey.wip.repository.UnitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UnitService {
    private final UnitRepo unitRepo;

    private void validate(UnitDto dto) {
        // get to know how to validate data best practice
        return;
    }

    public Unit createUnit(UnitDto dto) {
        validate(dto);
        Unit.UnitBuilder unitBuilder = Unit.builder()
            .name(dto.getName())
            .keywords(dto.getKeywords())
            .dateAdd(OffsetDateTime.now())
            .status(UnitStatus.NEW.getName())
            .progress(Optional.ofNullable(dto.getProgress()).orElse(0));
        if (null != dto.getDateAdd()) {
            unitBuilder.dateAdd(dto.getDateAdd());
        }
        if (null != dto.getStatus()) {
            UnitStatus unitStatus = UnitStatus.valueByName(dto.getStatus());
            unitBuilder.status(unitStatus.getName());
            if (UnitStatus.DONE.equals(unitStatus)) {
                unitBuilder.dateDone(OffsetDateTime.now());
            }
        }
        Unit u = unitBuilder.build();
        return unitRepo.save(u);
    }

    public Unit getUnit(long id) {
        return unitRepo.findById(id).orElseThrow(() -> new NotFoundException(id, "unit"));
    }

    public Page<Unit> getList(Pageable pageable) {
        return unitRepo.findAll(pageable);
    }

    public Unit updateUnit(long id, UnitDto dto) {
        Unit unit = unitRepo.findById(id).orElseThrow(() -> new NotFoundException(id, "unit"));
        unit.setName(dto.getName());
        unit.setKeywords(dto.getKeywords());
        unit.setProgress(dto.getProgress());
        if (null != dto.getStatus()) {
            UnitStatus unitStatus = UnitStatus.valueByName(dto.getStatus());
            unit.setStatus(unitStatus.getName());
            if (UnitStatus.DONE.equals(unitStatus)) {
                unit.setDateDone(OffsetDateTime.now());
            }
        }
        return unitRepo.save(unit);
    }
}
