package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findGamesByList(@PathVariable("listId") Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable("listId") Long listId, @RequestBody ReplacementDTO replacementDTO) {
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }


}
