package vitaliyRV.onlineShop.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import vitaliyRV.onlineShop.entity.User;
import vitaliyRV.onlineShop.repository.UserRepository;

@Component
public class UserValidator {
    private UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");

        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "size.newUserForm.username");
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "duplicate.newUserForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");

        if (user.getPassword().length() < 6) {
            errors.rejectValue("password", "size.newUserForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "different.newUserForm.password");
        }
    }
}
