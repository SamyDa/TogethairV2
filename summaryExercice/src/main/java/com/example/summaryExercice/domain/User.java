package com.example.summaryExercice.domain;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("U")
//If you want to change the name of columns or table after the extends (sub-classes) 
/*
 * @Table(name = "tc_country")
@AttributeOverrides({
    @AttributeOverride(name = "id", column =
            @Column(name = "COUNTRY_SID")),
    @AttributeOverride(name = "code", column =
            @Column(name = "COUNTRY_CODE")),
    @AttributeOverride(name = "description", column =
            @Column(name = "COUNTRY_DESCRIPTION"))})
 */
public abstract class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	private String password;

}
