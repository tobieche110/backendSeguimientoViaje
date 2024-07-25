package com.backendseguimientoviaje.socket.controller;

import com.backendseguimientoviaje.socket.model.Coordenada;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CoordenadaController {

    @MessageMapping("/taxi")
    @SendTo("/taxi/coordenada")
    public Coordenada envio(Coordenada coordenada){
        return coordenada;
    }

}
