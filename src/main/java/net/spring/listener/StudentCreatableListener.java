package net.spring.listener;

import net.spring.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class StudentCreatableListener {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(new Date().getTime());
    }
}
