package com.zxg.lambda;

import java.util.Optional;

public class OptionalDemo {

    public void testOptional(){
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        //判断optionUser是否为空
        optionalUser.isPresent();
        //获取optional中实体，若为空返回orElse中的数据
        User userGet = optionalUser.orElse(new User());

    }

    class User{
        public int age;
        public String name;
    }
}


