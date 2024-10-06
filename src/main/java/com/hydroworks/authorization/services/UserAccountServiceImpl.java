package com.hydroworks.authorization.services;

import static com.hydroworks.authorization.utils.Constants.INVALID_TOKEN_MESSAGE;
import static com.hydroworks.authorization.utils.Constants.RESOURCE_NOT_FOUND_MESSAGE;

import com.hydroworks.authorization.exceptions.ResourceNotFoundException;
import com.hydroworks.authorization.repositories.UserAccountRepository;
import com.hydroworks.authorization.services.interfaces.UserAccountService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.*;

import com.hydroworks.authorization.models.entities.UserAccount;
import com.hydroworks.authorization.models.entities.User;


@Service(value = "userAccountService")
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount save(User user, String token) {
        UserAccount newUserAccount = new UserAccount();
        Date dateNow = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateNow);
        c.add(Calendar.DATE, 2);

        newUserAccount.setUser(user)
                .setToken(token)
                .setExpireAt(c.getTime().getTime());

        return userAccountRepository.save(newUserAccount);
    }

    @Override
    public List<UserAccount> findAll() {
        List<UserAccount> list = new ArrayList<>();
        userAccountRepository.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Override
    public void delete(String id) {
        userAccountRepository.deleteById(new ObjectId(id));
    }

    @Override
    public UserAccount findByToken(String token) throws ResourceNotFoundException {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findByToken(token);

        if (userAccountOptional.isEmpty()) {
            throw new ResourceNotFoundException(INVALID_TOKEN_MESSAGE);
        }

        return userAccountOptional.get();
    }

    @Override
    public UserAccount findById(String id) throws ResourceNotFoundException {
        Optional<UserAccount> confirmAccountOptional = userAccountRepository.findById(new ObjectId(id));

        if (confirmAccountOptional.isEmpty()) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND_MESSAGE);
        }

        return confirmAccountOptional.get();
    }
}
