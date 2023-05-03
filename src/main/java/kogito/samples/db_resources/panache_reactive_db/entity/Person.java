package kogito.samples.db_resources.panache_reactive_db.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person{
    @Id 
    @GeneratedValue 
    private Long id;
    @Column(name = "user_name", length = 40, unique = true)
    private String username;
    @Column(length = 40, unique = true)
    private String name;
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private Status status;

}
