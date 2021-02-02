package ee.bcs.valiit.tasks;


import javax.persistence.*;

@Entity
@Table(name="turva")
public class UsersEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name="username")
private String userName;

private String pswrd;


@Column(name="userid")
private Integer userId;

@ManyToOne
@JoinColumn(name="userid", referencedColumnName = "id", insertable = false, updatable = false)
private CustomersEntity customersEntity;

 public UsersEntity() {


 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getUserName() {
  return userName;
 }

 public void setUserName(String userName) {
  this.userName = userName;
 }

 public String getPswrd() {
  return pswrd;
 }

 public void setPswrd(String pswrd) {
  this.pswrd = pswrd;
 }

 public Integer getUserId() {
  return userId;
 }

 public void setUserId(Integer userId) {
  this.userId = userId;
 }

 public CustomersEntity getCustomersEntity() {
  return customersEntity;
 }

 public void setCustomersEntity(CustomersEntity customersEntity) {
  this.customersEntity = customersEntity;
 }
}
