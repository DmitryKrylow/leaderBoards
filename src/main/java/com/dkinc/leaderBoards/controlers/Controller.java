package com.dkinc.leaderBoards.controlers;


import com.dkinc.leaderBoards.models.Company;
import com.dkinc.leaderBoards.models.User;
import com.dkinc.leaderBoards.repositories.CompanyRepos;
import com.dkinc.leaderBoards.repositories.UserRepos;
import org.apache.tomcat.util.buf.Ascii;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    public UserRepos userRepos;
    public CompanyRepos companyRepos;
    private final static Integer pass = -1063267386;

    public Controller(UserRepos userRepos, CompanyRepos companyRepos) {
        this.userRepos = userRepos;
        this.companyRepos = companyRepos;
    }

    @PostMapping("/putCompany")
    public String putCompanyDB(@RequestParam String name,
                               Integer countWorkers, String ownerName, Integer levelCompany)
    {
        List<Company> companyList = companyRepos.findByName(name);
        if (companyList.size() > 0){
            if(!companyList.get(0).ownerName.equals(ownerName)){
                return "This company already taken";
            }else{
                companyRepos.delete(companyList.get(0));
                companyRepos.save(new Company(name,countWorkers,ownerName,levelCompany));
                return "Complite update company";
            }
        }else{
            companyRepos.save(new Company(name, countWorkers, ownerName,levelCompany));
            return "add company complite";
        }
    }

    @PostMapping("/putUser")
    public String putUserDB(@RequestParam String nickname, Integer level, String email)
    {
        List<User> userList = userRepos.findByEmail(email);
        if(userList.size() > 0) {
            if (!userList.get(0).level.equals(level)) {
                userRepos.delete(userList.get(0));
                userRepos.save(new User(nickname, level, email));
                return "Complite update user";
            }
        }else{
            userRepos.save(new User(nickname,level,email));
            return "add user complite";
        }
        return "fail";
    }

    @GetMapping("/getUser")
    public String getMap(@RequestParam String nickname){
        if(nickname != null && !nickname.equals("")) {
            return userRepos.findByNickname(nickname).get(0).toString();
        }
        return "Пустые параетры";
    }

    @GetMapping("/getCompany")
    public List<Company> getCompany(@RequestParam String nameCompany, String ownerName){
        if((nameCompany != null && !nameCompany.equals("")) && (ownerName != null && !ownerName.equals("")))
            return companyRepos.findByNameAndOwnerName(nameCompany,ownerName);
        return null;
    }

    @PostMapping("/DKDELETEALLUSER")
    public String deleteAllUser(String pass){
        if(this.pass.equals(pass.hashCode())){
            userRepos.deleteAll();
            return "Complite delete";
        }else{
            return "Access is denied!";
        }
    }
    @PostMapping("/DKDELETEALLCOMPANY")
    public String deleteAllCompany(String pass){
        if(this.pass.equals(pass.hashCode())){
            userRepos.deleteAll();
            return "Complite delete";
        }else{
            return "Access is denied!";
        }
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userRepos.findAll(Sort.by(Sort.Direction.DESC,"level"));
    }

    @GetMapping("/getAllCompany")
    public List<Company> getAllCompany(){
        return companyRepos.findAll();
    }

    @GetMapping("/deleteUser")
    public String deleteUser(String nickname){
        userRepos.delete(userRepos.findByNickname(nickname).get(0));
        return "complite";
    }
}
