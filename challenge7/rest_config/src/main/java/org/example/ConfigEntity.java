package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.NamedQuery;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name = "config")
@NamedQuery(name = ConfigEntity.FIND_ALL, query = "FROM ConfigEntity")
public class ConfigEntity {
    public static final String FIND_ALL = "ConfigEntity.findAll";

    @Id
    @GeneratedValue(generator = "system-uuid2")
    @GenericGenerator(name = "system-uuid2", strategy = "uuid2")
    public String id;

    @Column(nullable = false)
    private Boolean active;
}
