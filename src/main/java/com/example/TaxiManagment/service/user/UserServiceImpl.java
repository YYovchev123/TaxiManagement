package com.example.TaxiManagment.service.user;

import com.example.TaxiManagment.exception.RecordBadRequestException;
import com.example.TaxiManagment.exception.RecordNotFoundException;
import com.example.TaxiManagment.model.User;
import com.example.TaxiManagment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new RecordBadRequestException("User with this email or phone is already exist.");
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(String.format("User with ID: %s, not found!", id)));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new RecordNotFoundException(String.format("User with email: %s, not found!", email)));
    }

    @Override
//    @Transactional
    public User update(User updatedUser, long Id) {
        User user = findById(Id);
        return update(user, updatedUser);
    }

    @Override
    public void deleteByID(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    private User update(User user, User updatedUser) {
        if (updatedUser.getFirstName() != null) {
            user.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            user.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(updatedUser.getPassword()));
        }
        if (updatedUser.getEmail() != null) {
            user.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPhone() != null) {
            user.setPhone(updatedUser.getPhone());
        }
        return user;
    }
}
