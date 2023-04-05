/*
 *
 * Talkdesk Confidential
 *
 * Copyright (C) Talkdesk Inc. 2023
 *
 * The source code for this program is not published or otherwise divested
 * of its trade secrets, irrespective of what has been deposited with the
 * U.S. Copyright Office. Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 */
package org.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class ConfigsRepository {

    @Inject
    EntityManager em;

    public ConfigEntity create(final ConfigEntity config) {
        em.persist(config);
        return config;
    }

    public ConfigEntity find(final String id) {
        return em.find(ConfigEntity.class, id);
    }
}
