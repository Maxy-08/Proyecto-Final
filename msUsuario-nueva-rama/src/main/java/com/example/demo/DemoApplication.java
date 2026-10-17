package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.consecionaria.entity.Sucursal;
import com.example.consecionaria.entity.Usuario;
import com.example.consecionaria.enums.Rol;
import com.example.consecionaria.repository.SucursalRepository;
import com.example.consecionaria.repository.UsuarioRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("com.example.consecionaria.repository")
@EntityScan({"com.example.consecionaria.entity", "com.example.consecionaria.enums"})
@ComponentScan({"com.example.demo", "com.example.consecionaria.*"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository, SucursalRepository sucursalRepository) {
        return args -> {
            // 1. Crear Sucursal por defecto si no existe
            Sucursal sucursalDefault = sucursalRepository.findById(1).orElseGet(() -> {
                Sucursal s = new Sucursal();
                s.setDireccion("Sucursal Central");
                return sucursalRepository.save(s);
            });

            // 2. Crear Usuario en texto plano sin encriptación
            String correoTest = "admin2026@test.com";
            if (usuarioRepository.findByCorreo(correoTest).isEmpty()) {
                Usuario u = new Usuario();
                u.setNombre("Admin General");
                u.setCorreo(correoTest);
                u.setContrasena("123456"); // Texto plano directo
                u.setRol(Rol.ADMIN);
                u.setSucursal(sucursalDefault);
                
                usuarioRepository.save(u);
                System.out.println("=================================================");
                System.out.println(">>> USUARIO CREADO EN TEXTO PLANO: admin2026@test.com / 123456 <<<");
                System.out.println("=================================================");
            }
        };
    }
}