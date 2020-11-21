package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                return users[index];
            }
        }
        throw new UserNotFoundException("User " + login + " not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean lessThanThree = user.getUsername().length() < 3;
        if (lessThanThree || !user.isValid()) {
            throw new UserInvalidException("User " + user.getUsername() + " is invalid");
        }
         else {
             return true;
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            uie.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}
