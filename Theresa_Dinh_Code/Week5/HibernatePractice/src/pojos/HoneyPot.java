package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEYPOT")
public class HoneyPot 
{
	@Id
	@Column(name="HONEY_ID")
	@SequenceGenerator(name="HONEYID_SEQ", sequenceName="HONEYID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HONEYID_SEQ")
	private int id; 
	
	@Column(name="AMOUNT")
	private double amount;
	
	public HoneyPot() {
		super();
	}

	public HoneyPot(double amount) {
		super();
		this.amount = amount;
	}

	public HoneyPot(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHoneyAmount() {
		return amount;
	}

	public void setHoneyAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "HoneyPot [id=" + id + ", honeyAmount=" + amount + "]";
	} 
	
	
}