package com.yourpc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
class AbstractEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
}
