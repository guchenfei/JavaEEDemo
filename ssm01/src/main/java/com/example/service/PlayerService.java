package com.example.service;

import com.example.pojo.Player;

import java.util.List;

public interface PlayerService {
    int addPlayer(Player player);

    List<Player> getAllPlayer();
}
