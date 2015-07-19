package com.shipinfoapp;

import com.google.gson.Gson;
import com.mongodb.*;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by NaveenPurmani on 07/18/2015.
 */
public class TodoService {

    private final DB db;
    private final DBCollection collection;

    public TodoService(DB db) {
        this.db = db;
        this.collection = db.getCollection("todos");
    }

    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>();
        DBCursor dbObjects = collection.find();
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            todos.add(new Todo((BasicDBObject) dbObject));
            
        }
        
        return todos;
    }

    public void createNewTodo(String body) {
        Todo todo = new Gson().fromJson(body, Todo.class);
        collection.insert(new BasicDBObject("vname", todo.getVname())
        								.append("vaddress", todo.getVaddress())
        								.append("compcode", todo.getCompcode())
        								.append("itemno", todo.getItemno())
        								.append("itemdesc", todo.getItemdesc())
        								.append("qty", todo.getQty())
        								.append("cmnts", todo.getCmnts())
        								.append("intlshipdocs", todo.getIntlshipdocs())
        								.append("shipdevdate", todo.getShipdevdate())
        								.append("instructions", todo.getInstructions())
        								.append("createdOn", new Date()));
    }

    
    public Todo find(String id) {
        return new Todo((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
    }
   

}
