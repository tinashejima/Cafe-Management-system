package com.inn.cafe.serviceImpl;

import com.inn.cafe.POJO.User;
import com.inn.cafe.constants.CafeConstants;
import com.inn.cafe.dao.UserDao;
import com.inn.cafe.service.UserService;
import com.inn.cafe.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Autowired
UserDao userDao;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signUp {}", requestMap);
        if (validateSignUpMap(requestMap)){
            User user = userDao.findByEmailId(requestMap.get("emailId"));
            if (Objects.isNull(user)){
                userDao.save()
            }
            else {
                 return CafeUtils.getResponseEntity("Email already exists.",HttpStatus.BAD_REQUEST );
            }

        }
        else {
            return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }

        return null;

    }

    private boolean validateSignUpMap(Map<String,String> requestMap){

        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
        && requestMap.containsKey("email") && requestMap.containsKey("password")) {
            return true;
        }
        return false;


    }


}
