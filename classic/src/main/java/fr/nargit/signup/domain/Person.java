package fr.nargit.signup.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSONS")
@Builder
@Getter
public class Person {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "person_id")
  private Long personId;

  @Column(name = "first_name")
  private String firstname;

  @Column(name = "last_name")
  private String lastname;

  @Temporal(TemporalType.DATE)
  @Column(name = "bird_date")
  private Date birthDate;

  @Column(name = "email")
  private String email;
}
