package org.example.domain.member;

import lombok.*;
import org.example.core.domain.Entity;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BookMember implements Entity {
    private long id;
    private String firstName;
    private String lastName;
    private Date regsterDate;
}
