package com.example.mapper;

import com.example.pojo.Player;

import java.util.List;

public interface PlayerMapper {
    int addPlayer(Player player);

//    @Select("select * from player")
    List<Player> getAllPlayer();
}
