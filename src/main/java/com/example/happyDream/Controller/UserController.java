package com.example.happyDream.Controller;

import com.example.happyDream.DTO.ChargerDTO;
import com.example.happyDream.DTO.UserDTO;
import com.example.happyDream.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //전체 사용자 조회
    @GetMapping("/users")
    public String userSelectAll(Model model) {
        List<UserDTO> users = this.userService.userSelectAll();
        return " ";
    }

}
