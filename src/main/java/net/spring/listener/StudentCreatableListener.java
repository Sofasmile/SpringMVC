package net.spring.listener;

import net.spring.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class StudentCreatableListener {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(LocalDateTime.now());
    }
}
