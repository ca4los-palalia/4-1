package com.cplsys.ai.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cplsys.ai.domain.PortfolioSlide;

@ManagedBean
@SessionScoped
public class PortfolioBean {

	private List<PortfolioSlide> diagrams1;
	private List<PortfolioSlide> diagrams2;
	private List<PortfolioSlide> softwareList;
	private List<PortfolioSlide> panelsList;
	private List<PortfolioSlide> instalationList;
	
	private PortfolioSlide portFolioSlide;
	  
    public PortfolioBean() {
        diagrams1 = new ArrayList<PortfolioSlide>();
        diagrams2 = new ArrayList<PortfolioSlide>();
        softwareList = new ArrayList<PortfolioSlide>();
        panelsList = new ArrayList<PortfolioSlide>();
        instalationList = new ArrayList<PortfolioSlide>();
        
        loadInformation();
    }
	
	public List<PortfolioSlide> getDiagrams1() {
		return diagrams1;
	}

	public void setDiagrams1(List<PortfolioSlide> diagrams1) {
		this.diagrams1 = diagrams1;
	}

	public List<PortfolioSlide> getDiagrams2() {
		return diagrams2;
	}

	public void setDiagrams2(List<PortfolioSlide> diagrams2) {
		this.diagrams2 = diagrams2;
	}

	public List<PortfolioSlide> getSoftwareList() {
		return softwareList;
	}

	
	public List<PortfolioSlide> getPanelsList() {
		return panelsList;
	}

	
	public List<PortfolioSlide> getInstalationList() {
		return instalationList;
	}

	private void loadInformation() {
		
		FacesContext jsfCtx= FacesContext.getCurrentInstance();
        ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");
        
		for (int i = 1; i <= 4; i++) {
			portFolioSlide = new PortfolioSlide();
			portFolioSlide.setImg(""+i+".jpg");
			portFolioSlide.setName(bundle.getString("lbl.portfolioDiagramsTab1img"+i+"Name"));
			portFolioSlide.setDescripcion(bundle.getString("lbl.portfolioDiagramsTab1img"+i+"Desc"));
			diagrams1.add(portFolioSlide);
		}
		
		for (int i = 1; i <= 4; i++) {
			portFolioSlide = new PortfolioSlide();
			portFolioSlide.setImg(""+i+".jpg");
			portFolioSlide.setName(bundle.getString("lbl.portfolioDiagramsTab2img"+i+"Name"));
			portFolioSlide.setDescripcion(bundle.getString("lbl.portfolioDiagramsTab2img"+i+"Desc"));
			diagrams2.add(portFolioSlide);
		}
		
		
		for (int i = 1; i <= 9; i++) {
			portFolioSlide = new PortfolioSlide();
			portFolioSlide.setImg(""+i+".jpg");
			portFolioSlide.setName(bundle.getString("lbl.portfolioSoftwareTab1img"+i+"Name"));
			portFolioSlide.setDescripcion(bundle.getString("lbl.portfolioSoftwareTab1img"+i+"Desc"));
			softwareList.add(portFolioSlide);
		}
		
		for (int i = 1; i <= 4; i++) {
			portFolioSlide = new PortfolioSlide();
			portFolioSlide.setImg(""+i+".jpg");
			portFolioSlide.setName(bundle.getString("lbl.portfolioPanelImg"+i+"Name"));
			portFolioSlide.setDescripcion(bundle.getString("lbl.portfolioPanelImg"+i+"Desc"));
			panelsList.add(portFolioSlide);
		}
		
		for (int i = 1; i <= 4; i++) {
			portFolioSlide = new PortfolioSlide();
			portFolioSlide.setImg(""+i+".jpg");
			portFolioSlide.setName(bundle.getString("lbl.portfolioInstalationImg"+i+"Name"));
			portFolioSlide.setDescripcion(bundle.getString("lbl.portfolioInstalationImg"+i+"Desc"));
			instalationList.add(portFolioSlide);
		}
	}
    
   
}
