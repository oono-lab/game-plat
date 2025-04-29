package com.example.demo.controller;



import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;

    /** サインアップ画面を GET で開くようにしておく（エラー表示のためにモデルを渡せるように） */
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        // signupError を空で初期化しておく
        model.addAttribute("signupError", "");
        return "login";
    }
    
    @PostMapping("/signup")
    public String signup(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        // ユーザーネーム重複チェック
        if (userService.usernameExists(username)) {
            model.addAttribute("signupError", "そのユーザーネームはすでに使われています");
            return "login";
        }
        // メールアドレス重複チェック
        if (userService.emailExists(email)) {
            model.addAttribute("signupError", "そのメールアドレスはすでに登録されています");
            return "login";
        }

        // 問題なければ登録してログインページへリダイレクト
        userService.registerUser(username, email, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
