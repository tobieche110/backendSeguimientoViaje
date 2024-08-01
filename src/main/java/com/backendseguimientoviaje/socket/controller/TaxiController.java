package com.backendseguimientoviaje.socket.controller;

import com.backendseguimientoviaje.socket.model.Coordenada;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxiapp")
public class TaxiController {

    private final SimpMessagingTemplate template; // Proporciona acceso a los metodos para enviar mensajes por el Socket

    // Constructor
    public TaxiController(SimpMessagingTemplate template){
        this.template = template;
    }

    // Las coordenadas se reciben por este metodo POST. Este las recibe y las envia a los subscriptores de /taxi/coordenada
    @PostMapping("/send-coordenada")
    public void sendCoordenada(@RequestBody Coordenada coordenada) {
        this.template.convertAndSend("/taxi/coordenada", coordenada);
    }
}
