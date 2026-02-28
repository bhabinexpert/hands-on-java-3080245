package bank;

public class Customer {
  private int id; // cannot be executed the variable id outside this class.
  private String username;
  private String name;
  private String password;
  private int accountId;

  public Customer(int id, String username, String name, String password, int acountId){
    setId(id);
    setName(username);
    setUsername(name);
    setPassword(password);
    setAccountId(acountId);

  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getAccountId() {
    return accountId;
  }
  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }
  
}
