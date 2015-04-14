package edu.neu.cs5200.hw5.orm.dao;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.neu.cs5200.hw5.orm.models.Site;

import java.util.*;

@Path("/site")
public class SiteService {
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Site updateSite(@PathParam("id") int id){
		SiteDAO dao =  new SiteDAO();
		Site s = dao.findSiteById(id);
		s.setLatitude(0.00);
		return dao.updateSite(s);
	}
	
	
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site removeSite(@PathParam("id") int id){
		SiteDAO dao = new SiteDAO();
		return dao.removeSite(id);
	}
	
	
	
	
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createSite(Site site){
		SiteDAO dao = new SiteDAO();
		dao.createSite(site);
	}
	
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSiteById(@PathParam("id") int id){
		SiteDAO dao = new SiteDAO();
		return dao.findSiteById(id);
	}
	
	
	
	
	
	
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites(){
		SiteDAO dao = new SiteDAO();
		return dao.findAllSites();
	}
}
