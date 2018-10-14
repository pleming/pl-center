package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.dto.UserAuthDTO;
import org.computerized.pl.dto.UserDTO;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.users.PasswdChkVO;
import org.computerized.pl.model.users.UserVO;
import org.computerized.pl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signin", method = {RequestMethod.GET})
    public String renderSignIn() {
        return "users/signin";
    }

    @RequestMapping(value = "signup", method = {RequestMethod.GET})
    public String renderSignUp() {
        return "users/signup";
    }

    @RequestMapping(value = "profile", method = {RequestMethod.GET})
    public ModelAndView renderProfile(HttpSession httpSession, ModelAndView mav) {
        setSidebarPath(httpSession, mav, "users/profile");
        return mav;
    }

    @RequestMapping(value = "profileUser", method = {RequestMethod.GET})
    public ModelAndView renderProfileUser(HttpSession httpSession, ModelAndView mav) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        setSidebarPath(httpSession, mav, "users/profileUser");
        return mav;
    }

    @RequestMapping(value = "signout", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO renderSignout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ResponseVO(true, 1, "로그아웃을 성공하였습니다.");
    }

    @RequestMapping(value = "signin", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO signin(HttpSession httpSession, @RequestBody UserVO userVO) {
        UserDTO userDTO = UserDTO.parseUserDTO(userVO);
        boolean isExist = userService.isExistUser(userDTO);

        if (!isExist)
            return new ResponseVO(false, 1, "아이디나 패스워드가 틀렸습니다.");

        UserAuthDTO userAuthDTO = userService.signin(userDTO);

        if (userAuthDTO == null)
            return new ResponseVO(false, 2, "아이디나 패스워드가 틀렸습니다.");

        SessionVO sessionVO = SessionVO.parseSessionVO(userAuthDTO);

        httpSession.setAttribute("sessionInfo", sessionVO);

        return new ResponseVO(true, 1, "로그인을 성공하였습니다.");
    }

    @RequestMapping(value = "signup", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO signup(@RequestBody UserVO userVO) {
        UserDTO userDTO = UserDTO.parseUserDTO(userVO);

        if (userService.isExistUser(userDTO))
            return new ResponseVO(false, 1, "동일한 아이디가 존재합니다.");

        userService.signup(userDTO);
        return new ResponseVO(true, 1, "회원가입을 성공하였습니다.");
    }

    @RequestMapping(value = "checkPasswd", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO checkPasswd(HttpSession httpSession, @RequestBody PasswdChkVO passwdChkVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        passwdChkVO.setUserCode(sessionVO.getUserCode());

        if (userService.checkPasswd(passwdChkVO))
            return new ResponseVO(true, 1, "/users/profileUser");

        return new ResponseVO(true, 2, "비밀번호가 일치하지 않습니다.");
    }

    @RequestMapping(value = "loadUserInfo", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO loadUserInfo(HttpSession httpSession) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        UserVO userVO = userService.loadUserInfo(userCode);

        return new ResponseVO(true, 1, userVO);
    }

    @RequestMapping(value = "updateUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO updateUserInfo(HttpSession httpSession, @RequestBody UserVO userVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        userService.updateUserInfo(userCode, userVO);
        return new ResponseVO(true, 1, "회원정보 변경을 완료하였습니다.");
    }

    private void setSidebarPath(HttpSession httpSession, ModelAndView mav, String viewName) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer auth = sessionVO.getAuth();
        String sidebarPath = null;

        switch (auth) {
            case 0:
                sidebarPath = CodeDefinition.SidebarPath.STUDENT.getPath();
                break;
            case 1:
                sidebarPath = CodeDefinition.SidebarPath.WORKER.getPath();
                break;
            case 2:
                sidebarPath = CodeDefinition.SidebarPath.LECTURER.getPath();
                break;
            case 3:
                sidebarPath = CodeDefinition.SidebarPath.ADMIN.getPath();
                break;
        }

        mav.addObject("sidebarPath", sidebarPath);
        mav.setViewName(viewName);
    }
}
