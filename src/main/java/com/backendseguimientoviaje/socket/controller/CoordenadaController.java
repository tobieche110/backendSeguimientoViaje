package com.backendseguimientoviaje.socket.controller;

import com.backendseguimientoviaje.socket.model.Coordenada;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CoordenadaController {

    @MessageMapping("/taxi") // Las coordenadas son recibidas a /app/taxi/, en ese momento se ejecuta este metodo
    @SendTo("/taxi/coordenada") // Se enviaran las coordenadas a los subscriptores de este destino
    public Coordenada envio(Coordenada coordenada){
        return coordenada;
    }

}
