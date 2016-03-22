package com.cplsys.ai.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cplsys.ai.domain.Project;

@ManagedBean
@SessionScoped
public class ProjectsBean {

	private List<Project> projects;
	private Project project;
	
	private String header;
	private String titleLabel;
	private String descLabel;
	private String dateLabel;
	private String locLabel;
	private String detailLabel; 
	
	
	public ProjectsBean() {
		projects = new ArrayList<Project>();
		loadInfo();
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}	

	public String getHeader() {
		return header;
	}
	public String getTitleLabel() {
		return titleLabel;
	}
	public String getDescLabel() {
		return descLabel;
	}
	public String getDateLabel() {
		return dateLabel;
	}
	public String getLocLabel() {
		return locLabel;
	}	
	public String getDetailLabel() {
		return detailLabel;
	}



	private void loadInfo(){
		FacesContext jsfCtx= FacesContext.getCurrentInstance();
        ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");
		
        for (int i = 1; i <= 48; i++) {
			project = new Project();
			project.setTitle(bundle.getString("lbl.portfolioProject"+i+"Title"));
			project.setDescription(bundle.getString("lbl.portfolioProject"+i+"Description"));
			project.setDate(bundle.getString("lbl.portfolioProject"+i+"Date"));
			project.setLocation(bundle.getString("lbl.portfolioProject"+i+"Location"));
			project.setImgName(i+".jpg");
			
			if(bundle.getString("lbl.portfolioProject"+i+"Type").equals("0"))
				project.setIcoName("projectNationalLogo.png");
			else
				project.setIcoName("projectInternationalLogo.png");
			
			projects.add(project);
		}
        
        header = bundle.getString("lbl.portfolioProjectLabelHeader");
        titleLabel = bundle.getString("lbl.portfolioProjectLabelTitle");
    	descLabel = bundle.getString("lbl.portfolioProjectLabelDescription");
    	dateLabel = bundle.getString("lbl.portfolioProjectLabelDate");
    	locLabel = bundle.getString("lbl.portfolioProjectLabelLocation");
    	
    	
    	detailLabel = bundle.getString("lbl.portfolioProjectLabelDetail");
    	
	}
}
