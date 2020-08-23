package org.websparrow.audit;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long>{

    @CreationTimestamp
    @Setter(AccessLevel.PROTECTED)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @UpdateTimestamp
    @Setter(AccessLevel.PROTECTED)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Version
    private final Long version = 0L;
}
