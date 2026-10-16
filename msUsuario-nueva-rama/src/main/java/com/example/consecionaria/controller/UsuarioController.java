package com.example.consecionaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.consecionaria.dto.PaginadoDto;
import com.example.consecionaria.dto.SucursalDto;
import com.example.consecionaria.dto.UsuarioDto;
import com.example.consecionaria.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> registro(@RequestBody UsuarioDto usuarioDto) throws Exception {
        UsuarioDto usuarioGuardado = usuarioService.saveUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioDto> obtenerPorCorreo(@PathVariable String correo) {
        try {
            UsuarioDto usuarioDto = usuarioService.findByCorreo(correo);
            return ResponseEntity.ok(usuarioDto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto usuarioDto) {
        try {
            UsuarioDto usuarioVerificado = usuarioService.verificarCredenciales(usuarioDto.getCorreo(), usuarioDto.getContrasena());
            return ResponseEntity.ok(usuarioVerificado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/perfil/{correo}")
    public ResponseEntity<UsuarioDto> obtenerPerfil(@PathVariable String correo) {
        try {
            UsuarioDto usuarioDto = usuarioService.findByCorreo(correo);
            return ResponseEntity.ok(usuarioDto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/listar/paginado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaginadoDto<UsuarioDto>> listarConPaginado(
            @RequestParam Integer size,
            @RequestParam String sort,
            @RequestParam Integer numPage
            ) throws Exception {
        Page<UsuarioDto> pageResult = usuarioService.listarUsuariosPaginados(size, sort, numPage);
        PaginadoDto<UsuarioDto> response = new PaginadoDto<>(
                pageResult.getContent(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.getSize(),
                pageResult.getNumber()
                );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sucursales")
    public ResponseEntity<List<SucursalDto>> listarSucursales() throws Exception {
        List<SucursalDto> sucursales = usuarioService.listarSucursales();
        return ResponseEntity.ok(sucursales);
    }
}