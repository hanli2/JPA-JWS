package edu.neu.cs5200.hw5.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.hw5.orm.models.Site;
import edu.neu.cs5200.hw5.orm.models.Tower;



public class SiteDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Homework5");
	EntityManager em = factory.createEntityManager();
	
	
	//createSite
	public Site createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return site;
	}
	
//	public static void main(String[] args) {
//		SiteDAO dao = new SiteDAO();
//		
//		Site site = new Site(3, "Site3", 33.33, 66.66);
//		site = dao.createSite(site);
//		List<Site> sites = dao.findAllSites();
//		for(Site site1 : sites){
//			System.out.println(site1.getName());
//		}
//
//	
//   }
	
	
	
	//findSite
	public Site findSiteById(Integer id){
		return em.find(Site.class, id);
	}
	
//	public static void main(String[] args){
//		SiteDAO dao = new SiteDAO();
//		Site site = dao.findSiteById(3);
//		System.out.println(site.getName());
//		Site Site2 = dao.findSiteById(2);
//		List<Tower> towers = Site2.getTowers();
//				for(Tower tower : towers) {
//					System.out.println(tower.getName());
//				}
//	}
	
	
	//findAllSite
	public List<Site> findAllSites(){
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();

	}
	
//	public static void main(String[] args){
//		SiteDAO dao = new SiteDAO();
//		List<Site> sites = dao.findAllSites();
//		for(Site site : sites){
//			System.out.println(site.getName());
//		}
//	}
	
	
	//updateSite
	public Site updateSite(Site site){
		em.getTransaction().begin();
		em.merge(site);
		em.getTransaction().commit();
		return site;
	}
	
	public static void main(String[] args){
		SiteDAO dao = new SiteDAO();
		Site Site3 = dao.findSiteById(3);
		System.out.println(Site3.getName());
		List<Site> sites = dao.findAllSites();
		for(Site site : sites){
			System.out.println(site.getName());
		}
		
		Site3.setLatitude(44.44);
		dao.updateSite(Site3);
	}
	
	
	
	// removeSite
	public Site removeSite(int id) {
		em.getTransaction().begin();
		Site site = em.find(Site.class, id);
		em.remove(site);
		em.getTransaction().commit();
		return site;
	}
	
//	public static void main(String[] args){
//		SiteDAO dao = new SiteDAO();
//		dao.removeSite(3);
//		List<Site> sites = dao.findAllSites();
//		for(Site site : sites){
//			System.out.println(site.getName());
//		}
//	}
//
//
//	
}