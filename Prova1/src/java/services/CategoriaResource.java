/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import models.Categoria;

/**
 * REST Web Service
 *
 * @author Matheus-PC
 */
@Path("categoria")
public class CategoriaResource {
    


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoriaResource
     */
    public CategoriaResource() {
    }

    /**
     * Retrieves representation of an instance of services.CategoriaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
      Gson gson = new Gson();
      return gson.toJson(DaoCategoria.getAll());     
    }

    /**
     * PUT method for updating or creating an instance of CategoriaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public boolean inserirCategoria(String content) {
        Gson gson = new Gson();
        Categoria ca = (Categoria) gson.fromJson(content, Categoria.class);
        return DaoCategoria.persist(ca);
    }
    
    @Path("{categoriaId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategoria(@PathParam("categoriaId") String id) {        
        Gson gson = new Gson();
        Categoria ct = new Categoria();
        ct = DaoCategoria.getOne(Long.parseLong(id));
        return gson.toJson(ct);     
    }
    
  
    @Path("excluir/{categoriaId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluirCategoria(@PathParam("categoriaId") String id) {
        return DaoCategoria.excluir(Long.parseLong(id));
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean alterarCategoria(String content) {
        Gson gson = new Gson();
        Categoria ct = (Categoria) gson.fromJson(content, Categoria.class);
        return DaoCategoria.editar(ct);
    }
    
}
