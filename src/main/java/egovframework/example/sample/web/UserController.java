package egovframework.example.sample.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.user.UserVO;
import egovframework.example.sample.service.user.impl.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String signinForm() {
		return "signupForm";
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String signup(UserVO userVO) throws Exception {
		
		System.out.println("UserVO : " + userVO.getUSER_ID());
		
		int result = userService.insertUserInfo(userVO);
		
		// 중복되는 아이디일 시 회원가입 페이지로 반환
		if(result == 1) {
			return "signupForm";
		}
		
		return "main";
	}
	
	@RequestMapping(value="/signin.do", method=RequestMethod.GET)
	public String signupForm() {
		return "signinForm";
	}
	
	@RequestMapping(value="/signin.do", method=RequestMethod.POST)
	public String signin(UserVO userVO, Model model) throws Exception {
		
		String userId = userService.getUserIdById(userVO.getUsername());
		System.out.println("signin userId : " + userId);
		// 일치하는 user 정보 없을 시 로그인 페이지로 반환
		if(userId.isEmpty()) {
			return "main";
		}
		
		model.addAttribute("USER", userVO);
		
		return "signinAfter";
	}
	
	@RequestMapping(value="/signinAfter.do", method=RequestMethod.GET)
	public String signinAfter() {
		return "signinAfter";
	}

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout() {
		return "main";
	}
	
	// ********** ADMIN **********
	@RequestMapping(value="/admin/adminPage.do", method=RequestMethod.GET)
	public String adminAccess() {

		return "admin/adminPage";
	}
	
	@RequestMapping(value="/admin/userList.do", method=RequestMethod.GET)
	public String userList(Model model) throws Exception {
		
		List<UserVO> list = (List<UserVO>) userService.getUserList();
		
		model.addAttribute("list", list);

		return "admin/userList";
	}
	
	@RequestMapping(value="/admin/userDetail", method=RequestMethod.GET)
	public String boardDetail(@RequestParam("id") String USER_ID, Model model) throws Exception {
		
		UserVO user = userService.getUserDetailByUserId(USER_ID);
		
		model.addAttribute("user", user);
	    
		return "admin/userDetail";
	}
	
	
	@RequestMapping(value="/admin/registerUser.do", method=RequestMethod.GET)
	public String registerUserForm() {
		return "admin/userRegisterForm";
	}
	
	@RequestMapping(value="/admin/registerUser.do", method=RequestMethod.POST)
	public String registerUser(UserVO userVO) throws Exception {
		
		System.out.println("register user controller user authority : " + userVO.getUSER_AUTHORITY());
		
		int result = userService.insertUserInfo(userVO);
		
		// 중복되는 아이디일 시 관리자 메인 페이지로 반환
		if(result == 1) {
			return "admin/adminPage";
		}
		
		return "admin/userRegisterForm";
	}
	
	@RequestMapping(value="/admin/updateUserInfo.do", method=RequestMethod.POST)
	public String updateBoardContent(UserVO userVO, Model model) throws Exception {
		
		UserVO updatedUser = userService.updateUserInfo(userVO);
		
		model.addAttribute("user", updatedUser);
		
		return "admin/userDetail";
	}
	
	@RequestMapping(value="/admin/deleteUserInfo", method=RequestMethod.GET)
	public String deleteUserInfo(@RequestParam("id") String USER_ID, Model model) throws Exception {
		
		userService.deleteUserInfo(USER_ID);
		
		List<UserVO> list = (List<UserVO>) userService.getUserList();
		
		model.addAttribute("list", list);
		
		return "admin/userList";
	}

}
