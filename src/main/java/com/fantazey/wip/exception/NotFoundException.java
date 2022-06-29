package com.fantazey.wip.exception;

import javax.persistence.EntityNotFoundException;

public class NotFoundException extends EntityNotFoundException {
    public NotFoundException(Long id, String entityName) {
        super(String.format("%s with id=%s not found", entityName, id));
    }
}
