package com.shipinfoapp;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 * Created by NaveenPurmani on 07/18/15.
 */
public class TodoResources {

    private static final String API_CONTEXT = "/api/v2";

    private final TodoServices todoServices;

    public TodoResources(TodoServices todoServices) {
        this.todoServices = todoServices;
        setupEndpoints();
    }

    private void setupEndpoints() {
 	
        post(API_CONTEXT + "/todosi", "application/json", (request, response) -> {
            todoServices.createNewTodo(request.body());
            response.status(201);
            System.out.println("post create");
            return response;
        }, new JsonTransformer());

       
        
        get(API_CONTEXT + "/todos/:id", "application/json", (request, response)

                -> todoServices.find(request.params(":id")), new JsonTransformer());


        get(API_CONTEXT + "/todosi", "application/json", (request, response)

                -> todoServices.findAll(), new JsonTransformer());
        
   //     put(API_CONTEXT + "/todos/:id", "application/json", (request, response)

   //             -> todoService.update(request.params(":id"), request.body()), new JsonTransformer());
    
   //     put(API_CONTEXT + "/todo/:id", "application/json", (request, response)

   //               -> todoService.deleteTodos(request.params(":id")), new JsonTransformer());
        
    }


}
