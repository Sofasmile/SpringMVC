package net.spring.entity;

import lombok.Setter;
import net.spring.listener.StudentCreatableListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@EntityListeners(value = StudentCreatableListener.class)
public class CreatableEntity {
    @Column(name = "created_date")
    private Long createdDate;
}
