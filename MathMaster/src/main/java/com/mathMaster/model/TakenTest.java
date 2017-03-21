package com.mathMaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="M2_TAKEN_TEST")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class TakenTest {
	@Id
	@Column(name="TAKEN_TEST_ID")
	@SequenceGenerator(name="TAKEN_TEST", sequenceName="TAKEN_TEST_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="TAKEN_TEST", strategy=GenerationType.SEQUENCE)
	private int takenTestId;
	
	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private Test testId;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Student studentId;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="TIME_TAKEN")
	private int timeTaken;
}
