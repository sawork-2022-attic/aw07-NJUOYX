package com.micropos.poscounter.service;

import com.micropos.poscounter.model.User;
import com.micropos.poscounter.repository.CounterRepository;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService{

    private CounterRepository counterRepository;

    @Override
    public User checkUser(String uid, String password) {
        User target = counterRepository.getUser(uid);
        if(target.getPassword().equalsIgnoreCase(password)){
            return target;
        }
        return null;
    }
}
