package com.fantazey.wip.repository;

import com.fantazey.wip.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends CrudRepository<Unit, Long> {
    Page<Unit> findAll(Pageable pageable);
}
