package com.ti2cc;

import static spark.Spark.*;
	
public class Aplicacao {
	
	private static RelatoService relatoService = new RelatoService();
	private static UsuarioService usuarioService = new UsuarioService();
	
    public static void main(String[] args) {
        port(5500);
        //staticFiles.location("/");
        
        post("/login", (request, response) -> usuarioService.login(request, response));        
        
        post("/relato", (request, response) -> relatoService.add(request, response));

        get("/relato/:id", (request, response) -> relatoService.get(request, response));

        get("/relato/update/:id", (request, response) -> relatoService.update(request, response));

        get("/relato/delete/:id", (request, response) -> relatoService.remove(request, response));

        get("/relato", (request, response) -> relatoService.getAll(request, response));
        
        post("/usuario", (request, response) -> usuarioService.add(request, response));

        get("/usuario/:login", (request, response) -> usuarioService.get(request, response));

        get("/usuario/update/:login", (request, response) -> usuarioService.update(request, response));

        get("/usuario/delete/:login", (request, response) -> usuarioService.remove(request, response));

        get("/usuario", (request, response) -> usuarioService.getAll(request, response));

               
    }
}