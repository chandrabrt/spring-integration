package org.websparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
@NoRepositoryBean
public interface CustomJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
