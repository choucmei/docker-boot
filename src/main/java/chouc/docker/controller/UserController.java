package chouc.docker.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chouc.docker.entities.User;
import chouc.docker.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/user/find/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }
}

