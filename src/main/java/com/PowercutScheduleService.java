package com;

import model.PowercutSchedule; 

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/PowercutSchedule")


public class PowercutScheduleService 
	{
		PowercutSchedule itemObj = new PowercutSchedule();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readPowercutSchedule()
		 {
		 return "Hello";
		 }
		}
