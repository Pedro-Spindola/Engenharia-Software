package com.spindola.atividade_05.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_05.model.enums.TipoAdicionais;
import com.spindola.atividade_05.model.enums.TipoCafe;
import com.spindola.atividade_05.model.interfaces.ICafe;
import com.spindola.atividade_05.services.CafeService;

@RestController
@RequestMapping("/api/cafes")
public class CafeController {

    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @PostMapping("/pedido")
    public ResponseEntity<?> realizarPedido(@RequestBody Map<String, Object> pedido) {

        try {
            String tipoString = (String) pedido.get("tipo");
            List<String> adicionaisStrings = (List<String>) pedido.get("adicionais");

            TipoCafe tipoEnum = TipoCafe.valueOf(tipoString.toUpperCase());

            List<TipoAdicionais> adicionaisEnums = adicionaisStrings.stream().map(adicional -> TipoAdicionais.valueOf(adicional.toUpperCase())).collect(Collectors.toList());

            ICafe cafeFinal = cafeService.processarPedido(tipoEnum, adicionaisEnums);
            
            return ResponseEntity.ok(cafeFinal);

        } catch (IllegalArgumentException e) {
            String mensagemErro = "Valores de entrada inválidos. Por favor, verifique o tipo de café ou os adicionais.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }
    }
    
}
