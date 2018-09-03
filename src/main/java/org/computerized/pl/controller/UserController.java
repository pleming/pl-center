package org.computerized.pl.controller;

import org.computerized.pl.dto.UserAuthDTO;
import org.computerized.pl.dto.UserDTO;
import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.model.SessionVO;
import org.computerized.pl.model.UserVO;
import org.computerized.pl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String renderSignIn() {
        return "users/signin";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String renderSignUp() {
        return "users/signup";
    }

    @RequestMapping(value = "signout", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO renderSignout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ResponseVO(true, 1, "로그아웃을 성공하였습니다.");
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO signin(HttpSession httpSession, @RequestBody UserVO userVO) {
        UserDTO userDTO = UserDTO.parseUserDTO(userVO);
        boolean isExist = userService.isExistUser(userDTO);

        if(!isExist)
            return new ResponseVO(true, 1, "아이디나 패스워드가 틀렸습니다.");

        UserAuthDTO userAuthDTO = userService.signin(userDTO);
        SessionVO sessionVO = SessionVO.parseSessionVO(userAuthDTO);

        httpSession.setAttribute("sessionInfo", sessionVO);

        return new ResponseVO(true, 2, "로그인을 성공하였습니다.");
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO signup(@RequestBody UserVO userVO) {
        UserDTO userDTO = UserDTO.parseUserDTO(userVO);

        if(userService.isExistUser(userDTO))
            return new ResponseVO(true, 1, "동일한 아이디가 존재합니다.");

        userService.signup(userDTO);
        return new ResponseVO(true, 2, "회원가입을 성공하였습니다.");
    }
}
