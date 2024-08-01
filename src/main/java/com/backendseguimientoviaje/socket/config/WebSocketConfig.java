package com.backendseguimientoviaje.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/taxi", "/tema"); // Son las rutas a las que se subscribiran para recibir datos
        registry.setApplicationDestinationPrefixes("/app"); // Prefijo para recibir datos enviados al socket (@MessageMapping)
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("websocket") // Endpoint al que el cliente debe conectarse para enviar y recibir datos
                .setAllowedOrigins("*"); // Se habilitan todos los origenes (cualquier url puede conectarse al endpoint)
    }
}
