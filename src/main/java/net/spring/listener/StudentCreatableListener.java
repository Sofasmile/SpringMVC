package net.spring.listener;

import net.spring.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;

public class StudentCreatableListener {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(LocalDate.now());
    }
}
