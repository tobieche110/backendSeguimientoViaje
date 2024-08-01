package com.backendseguimientoviaje.socket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.backendseguimientoviaje.socket.model.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensajeController {

    // Constante para acceder a los metodos necesarios para crear logs en la consola
    private static final Logger logger = LoggerFactory.getLogger(MensajeController.class);

    @MessageMapping("/envio") // Los mensajes son recibidos a /app/envio/, en ese momento se ejecuta este metodo
    @SendTo("/tema/mensajes") // Los mensajes son enviados a los subscriptores de /tema/mensajes a traves del return de este metodo
    public Mensaje envio(Mensaje mensaje){
        logger.info("Mensaje recibido: " + mensaje.nombre() + " - " + mensaje.contenido()); // Mensaje cuando se ejecuta el metodo por recibir un mensaje
        return new Mensaje(mensaje.nombre(), mensaje.contenido());
    }
}
