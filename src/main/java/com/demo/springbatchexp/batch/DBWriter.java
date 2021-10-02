package com.demo.springbatchexp.batch;

import com.demo.springbatchexp.model.User;
import com.demo.springbatchexp.repository.UserRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    UserRepo userRepo;

    @Override
    public void write(List<? extends User> users) throws Exception {
        userRepo.saveAll(users);
    }

}
