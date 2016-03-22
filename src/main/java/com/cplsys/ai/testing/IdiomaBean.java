package com.cplsys.ai.testing;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class IdiomaBean implements Serializable {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    private static Map<String, String> availableLanguages;

    static {
        availableLanguages = new LinkedHashMap<String, String>();
        availableLanguages.put("Español", "es");
        availableLanguages.put("English", "en");
    }

    public Map<String, String> getAvailableLanguages() {
        return availableLanguages;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        
    	locale = new Locale(language);
    	System.err.println(locale.getDisplayLanguage());
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}
