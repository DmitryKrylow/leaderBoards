package com.dkinc.leaderBoards.controlers;


import com.dkinc.leaderBoards.models.User;
import com.dkinc.leaderBoards.repositories.UserRepos;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    public UserRepos userRepos;
    private final static String pass = "1208DKdeleteAll";

    public Controller(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @PostMapping("/putUser")
    public String putUserDB(@RequestParam String nickname, Integer level, String email){
        List<User> userList = userRepos.findByEmail(email);
        if(userList.size() > 0){
            if(!userList.get(0).level.equals(level)){
                userRepos.delete(userList.get(0));
                userRepos.save(new User(nickname,level,email));
                return "Complite update user";
            }
        }else{
            userRepos.save(new User(nickname,level,email));
            return "add user complite";
        }
        return "Fail";
    }
    @GetMapping("/getUser")
    public String getMap(@RequestParam String nickname){
        if(nickname != null && !nickname.equals("")) {
            return userRepos.findByNickname(nickname).get(0).toString();
        }
        return "Пустые параетры";
    }
    @GetMapping("/DKDELETEALLUSER")
    public String delete(String pass){
        if(this.pass.equals(pass)){
            userRepos.deleteAll();
            return "Complite delete";
        }else{
            return "Access is denied!";
        }
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUSer(){

        return userRepos.findAll(Sort.by(Sort.Direction.DESC,"level"));
    }
    @GetMapping("/deleteUser")
    public String deleteUser(String nickname){
        userRepos.delete(userRepos.findByNickname(nickname).get(0));
        return "complite";
    }
}
