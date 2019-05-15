package net.spring.listener;

import net.spring.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class StudentLoggerListener {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PrePersist
    public void methodInvokedBeforePersist(Student student) {
        LOGGER.info("Persisting student with id = " + student.getId());
    }

    @PostPersist
    public void methodInvokedAfterPersist(Student student) {
        LOGGER.info("-----Persisted student with id = " + student.getId());
    }

    @PreUpdate
    public void methodInvokedBeforeUpdate(Student student) {
        LOGGER.info("-----Updating student with id = " + student.getId());
    }

    @PostUpdate
    public void methodInvokedAfterUpdate(Student student) {
        LOGGER.info("-----Updated student with id = " + student.getId());
    }

    @PreRemove
    private void methodInvokedBeforeRemove(Student student) {
        LOGGER.info("-----Removing student with id = " + student.getId());
    }

    @PostRemove
    public void methodInvokedAfterRemove(Student student) {
        LOGGER.info("-----Removed student with id = " + student.getId());
    }
}
