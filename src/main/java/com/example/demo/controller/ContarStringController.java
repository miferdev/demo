package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.contarStringService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ContarString")
public class ContarStringController {

    private final ContarStringService contarStringService;

    public ContarStringController(ContarStringService contarStringService) {
        this.contarStringService = contarStringService;
    }

    @GetMapping("/ContarString")
    public Map<String, Object> analizarTexto(
            @RequestParam String texto,
            @RequestParam(defaultValue = "true") boolean incluirEspacios) {

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("textoOriginal", texto);
        respuesta.put("totalCaracteres", contarStringService.contarTotal(texto, incluirEspacios));


        return respuesta;
    }
}
