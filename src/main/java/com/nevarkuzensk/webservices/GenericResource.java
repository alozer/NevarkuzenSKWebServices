/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevarkuzensk.webservices;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.ResultSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author ali
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    private Connection connection; 
    private ConnectionHelper connectionHelper;
    private DbOperations dbOperations;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.nevarkuzensk.webservices.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json; charset=UTF-8")
    public String getJson(@DefaultValue("defaultValue") @QueryParam("value") String value) throws Exception{
        connectionHelper = new ConnectionHelper();
        connection = connectionHelper.getConnection();
        dbOperations = new DbOperations();

        JSONObject jsonObj = new JSONObject();
        JSONObject jsonObj1 = new JSONObject();
        
        if("team".equals(value))
        {
            JSONArray teamsArray = new JSONArray();
            ResultSet rs = dbOperations.getTeams(connection);
            try 
            {
                while(rs.next())
                {
                    JSONObject teamObj = new JSONObject();
                    teamObj.put("id", rs.getInt(1));
                    teamObj.put("name", rs.getString(2));
                    teamsArray.add(teamObj);
                    //returnValue += rs.getInt(1) + "," + rs.getString(2) + "\n";
                }

                jsonObj.put("teams", teamsArray);


            } catch(Exception e)
            {
                throw e;
            }
            connectionHelper.closeConnection(connection);
        }
        
        return jsonObj.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
