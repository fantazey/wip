package com.fantazey.wip.controller;

import com.fantazey.wip.dto.UnitDto;
import com.fantazey.wip.entity.Unit;
import com.fantazey.wip.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/unit")
public class UnitController {
    private final UnitService unitService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Unit createUnit(@RequestBody UnitDto unitDto) {
        return unitService.createUnit(unitDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Unit getById(@PathVariable("id") long unitId) {
        return unitService.getUnit(unitId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Unit> getList(@RequestParam(defaultValue="5") int size,
                              @RequestParam(defaultValue="1") int page,
                              @RequestParam(defaultValue = "id:asc") String order) {
        String[] orderComponents = order.split(":");
        String sortField = orderComponents[0];
        Sort.Direction direction = Sort.Direction.fromString(orderComponents[1]);
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(new Sort.Order(direction, sortField)));
        return unitService.getList(pageable);
    }

    @PatchMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public Unit editUnit(@PathVariable("id") long id, @RequestBody UnitDto unitDto) {
        return unitService.updateUnit(id, unitDto);
    }
}
