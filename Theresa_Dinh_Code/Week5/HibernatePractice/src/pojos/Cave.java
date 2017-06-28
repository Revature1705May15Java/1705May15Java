package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave 
{
	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(name="CAVE_SEQ", sequenceName="CAVEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAVEID_SEQ")
	private int id; 
	
	@Column
	private double squareFootage; 

	@Column
	private double rent;
	
	public Cave() {
		super();
	}

	public Cave(double squareFootage, double rent) {
		super();
		this.squareFootage = squareFootage;
		this.rent = rent;
	}

	public Cave(int id, double squareFootage, double rent) {
		super();
		this.id = id;
		this.squareFootage = squareFootage;
		this.rent = rent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", squareFootage=" + squareFootage + ", rent=" + rent + "]";
	} 
}