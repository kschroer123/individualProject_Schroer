package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  item VARCHAR(30) NOT NULL,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  phone VARCHAR(30) NOT NULL,
  address VARCHAR(30) NOT NULL,   
  price VARCHAR(30) NOT NULL,   
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "kCustomTable2")
public class Kcustom {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "item")
   private String item;

   @Column(name = "firstName")
   private String firstName;
   
   @Column(name = "lastName")
   private String lastName;
   
   @Column(name = "phone")
   private String phone;
   
   @Column(name = "address")
   private String address;
   
   @Column(name = "price")
   private String price;

   public Kcustom() {
   }

   public Kcustom(Integer id, String item, String firstName, String lastName, String phone, String address, String price) {
      this.id = id;
      this.item = item;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
      this.price = price;
   }

   public Kcustom(String item, String firstName, String lastName, String phone, String address, String price) {
	  this.item = item;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
      this.price = price;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getItem() {
      return item;
   }

   public void setItem(String item) {
      this.item = item;
   }
   
   public String getFirstName() {
	  return firstName;
   }

   public void setFirstName(String item) {
      this.firstName = item;
   }
	   
   public String getLastName() {
	  return lastName;
   }

   public void setLastName(String item) {
      this.lastName = item;
   }
	   
   public String getPhone() {
	  return phone;
   }

   public void setPhone(String item) {
      this.phone = item;
   }
	   
   public String getAddress() {
	  return address;
   }

   public void setAddress(String item) {
      this.address = item;
   }
	   
   public String getPrice() {
	  return price;
   }

   public void setPrice(String item) {
      this.price = item;
   }
	   
	 
   @Override
   public String toString() {
      return "Employee: " + this.id + ", " + this.item + ", " + this.firstName + ", " + this.lastName + ", " + this.phone + ", " + this.address + ", " + this.price;
   }
}