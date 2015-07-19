package com.shipinfoapp;

import com.mongodb.BasicDBObject;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created by NaveenPurmani on 07/18/2015.
 */
public class Todo {

    private String id;
    private String vname;
    private String vaddress;
    private String compcode;
    private String itemno;
    private String itemdesc;
    private String qty;
    private String cmnts;
    private String intlshipdocs;
    private String shipdevdate;
    private String instructions;
    
    private String icnnum;
    private String date;
    private String time;
    private String mloc;
    private String person;
    private String pass;
    private String pack;
    private String icase;
    private String wt;
    private String type;
    
    private Date createdOn = new Date();

    public Todo(BasicDBObject dbObject) {
 
    	this.id = ((ObjectId) dbObject.get("_id")).toString();
      	this.vname = dbObject.getString("vname");
        this.vaddress  = dbObject.getString("vaddress");
        this.compcode  = dbObject.getString("compcode");
        this.itemno    = dbObject.getString("itemno");
        this.itemdesc  = dbObject.getString("itemdesc");
        this.qty       = dbObject.getString("qty");
        this.cmnts 	      = dbObject.getString("cmnts");
        this.intlshipdocs = dbObject.getString("intlshipdocs");
        this.shipdevdate  = dbObject.getString("shipdevdate");
        this.instructions = dbObject.getString("instructions");
        this.createdOn    = dbObject.getDate("createdOn");
    
        this.icnnum       = dbObject.getString("icnnum");
        this.date       = dbObject.getString("date");
        this.time       = dbObject.getString("time");
        this.mloc       = dbObject.getString("mloc");
        this.person       = dbObject.getString("person");
        this.pass       = dbObject.getString("pass");
        this.pack       = dbObject.getString("pack");
        this.icase       = dbObject.getString("icase");
        this.wt       = dbObject.getString("wt");
        this.type       = dbObject.getString("type");
    }

	
	public String getDate() {
		return date;
	}


	public String getTime() {
		return time;
	}


	public String getMloc() {
		return mloc;
	}


	public String getPerson() {
		return person;
	}


	public String getPass() {
		return pass;
	}


	public String getPack() {
		return pack;
	}


	public String getIcase() {
		return icase;
	}


	public String getWt() {
		return wt;
	}


	public String getType() {
		return type;
	}


	public String getItemno() {
		return itemno;
	}


	public String getItemdesc() {
		return itemdesc;
	}


	public String getQty() {
		return qty;
	}


	public String getCmnts() {
		return cmnts;
	}


	public String getIntlshipdocs() {
		return intlshipdocs;
	}


	public String getShipdevdate() {
		return shipdevdate;
	}


	public String getInstructions() {
		return instructions;
	}


	public String getVname() {
        return vname;
    }

    public String getVaddress() {
		return vaddress;
	}

	
	public String getCompcode() {
		return compcode;
	}

	

    public Date getCreatedOn() {
        return createdOn;
    }
    
    
	public String getIcnnum() {
		return icnnum;
	}
}
