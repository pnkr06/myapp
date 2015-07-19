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
public class TodoServices {

    private final DB db;
    private final DBCollection collection;

    public TodoServices(DB db) {
        this.db = db;
        this.collection = db.getCollection("todosi");
    }

    public List<Todo> findAll() {
        List<Todo> todosi = new ArrayList<>();
        DBCursor dbObjects = collection.find();
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            todosi.add(new Todo((BasicDBObject) dbObject));
            
        }
        
        return todosi;
    }

    public void createNewTodo(String body) {
        Todo todo = new Gson().fromJson(body, Todo.class);
        collection.insert(new BasicDBObject("icname", todo.getIcnnum())
        								.append("date", todo.getDate())
        								.append("time", todo.getTime())
        								.append("mloc", todo.getMloc())
        								.append("person", todo.getPerson())
        								.append("pass", todo.getPass())
        								.append("pack", todo.getPack())
        								.append("icase", todo.getIcase())
        								.append("wt", todo.getWt())
        								.append("type", todo.getType())
        								.append("createdOn", new Date()));
    }

    
    public Todo find(String id) {
        return new Todo((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
    }
   

}
