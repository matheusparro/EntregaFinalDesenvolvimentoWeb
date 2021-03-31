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
import models.Produto;

/**
 * REST Web Service
 *
 * @author Matheus-PC
 */
@Path("produto")
public class ProdutoResource {
    


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    /**
     * Retrieves representation of an instance of services.ProdutoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
      Gson gson = new Gson();
      return gson.toJson(DaoProduto.getAll());     
    }
    
    

    /**
     * PUT method for updating or creating an instance of ProdutoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)//VER COMO INSERIR A FOREIGN KEY NA PARADA SEPAASSA O ID DIRETO OU DENTRO DO COTENT
    public boolean inserirProduto(String content) {
        Gson gson = new Gson();
        Produto ca = (Produto) gson.fromJson(content, Produto.class);
        return DaoProduto.persist(ca);
    }
    
    @Path("{produtoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduto(@PathParam("produtoId") String id) {        
        Gson gson = new Gson();
        Produto ct = new Produto();
        ct = DaoProduto.getOne(Long.parseLong(id));
        return gson.toJson(ct);     
    }
    
    @Path("excluir/{produtoId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluir(@PathParam("produtoId") String id) {
      return DaoProduto.excluir(Long.parseLong(id));
    }    
     
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean alterarProduto(String content) {
        Gson gson = new Gson();
        Produto ct = (Produto) gson.fromJson(content, Produto.class);
        return DaoProduto.editar(ct);
    }
    
}
