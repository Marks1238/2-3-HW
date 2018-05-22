package lv.va.sludinajumuportals.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    String currentName = "Marks";
    public List<User> nameUserList;

    public UserService() {
        nameUserList = hardcodedUserInitialization();
    }

    public List<User> getUserListByAuthor(String name) {
        List<User> filteredByName = new ArrayList<>();
        for (User user : nameUserList) {
            if (user.getName().equals(name)) {
                filteredByName.add(user);
            }
        }
        return filteredByName;
    }

    private List<User> hardcodedUserInitialization() {
        List<User> users = new ArrayList();
        for (int i = 1; i < currentName.length(); i++) {
            User user = new User(Long.valueOf(i), "Name", "Surname" + i, getName(i));
            users.add(user);
        }
        return users;
    }

    private String getName(int i) {
        if (i % 2 == 0) {
            return "Peteris";
        }
        return "Marks";
    }
}
