package com.demo.springbatchexp.batch;

import com.demo.springbatchexp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    public static final Map<String, String> DEPT_NAMES = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(Processor.class);

    public Processor() {
        DEPT_NAMES.put("001", "Drilling");
        DEPT_NAMES.put("002", "Pumping");
        DEPT_NAMES.put("003", "Completion");
    }


    @Override
    public User process(User user) throws Exception {
        String dept = user.getDept();
        String deptName = DEPT_NAMES.get(dept);
        user.setDept(deptName);
        user.setTime(new Date());
        logger.info("Changed from {} to {}", dept, deptName);
        return user;
    }
}
