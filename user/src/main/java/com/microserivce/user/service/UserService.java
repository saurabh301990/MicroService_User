package com.microserivce.user.service;

import com.microserivce.user.VO.Department;
import com.microserivce.user.VO.ResponseTemplateVO;
import com.microserivce.user.entity.User;
import com.microserivce.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info(("Inside saveUser of User service"));
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserwithDepartcment(long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByuserId(userId);

        Department department = restTemplate.getForObject("http://Department-Service/department/" + user.getDepartmentId()
                , Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
