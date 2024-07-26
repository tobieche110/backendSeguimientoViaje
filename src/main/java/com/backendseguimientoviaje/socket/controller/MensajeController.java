package com.backendseguimientoviaje.socket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.backendseguimientoviaje.socket.model.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensajeController {

    private static final Logger logger = LoggerFactory.getLogger(MensajeController.class);

    @MessageMapping("/envio")
    @SendTo("/tema/mensajes")
    public Mensaje envio(Mensaje mensaje){
        logger.info("Mensaje recibido: " + mensaje.nombre() + " - " + mensaje.contenido());
        return new Mensaje(mensaje.nombre(), mensaje.contenido());
    }
}
