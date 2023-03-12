package com.example.controller;

import com.example.pojo.Player;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlayController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("/addPlayer")
    public String addPlayer(Player player){
        System.out.println(player);
        playerService.addPlayer(player);
        return "redirect:showPlayer.jsp";
    }

    @ResponseBody
    @RequestMapping("/getAllPlayer")
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayer();
    }
}
