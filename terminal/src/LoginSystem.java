import java.util.*;

class LoginSystem {
  private List<User> users;

  public LoginSystem() {
      users = new ArrayList<>();
      users.add(new Admin("admin", "123"));
      users.add(new Kasir("kasir", "123"));
  }
 
  public String login(String username, String password) {
      for (User user : users) {
          if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
              return user.getUsername();
          }
      }
      return null;
  }
}