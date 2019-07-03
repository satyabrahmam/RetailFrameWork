package com.training.bean;

/*
 * Class will set and get the Category Detail
 * 
 */

public class CategoryBean {
	
	private String categoryname;
	private String description;
	private String metaTagTitle;
	private String metaTagDescription;

	public CategoryBean() {
	}

	public CategoryBean(String categoryname, String description,String metaTagTitle, String metaTagDescription ) {
		super();
		this.categoryname = categoryname;
		this.description = description;
		this.metaTagTitle = metaTagTitle;
		this.metaTagDescription =  metaTagDescription;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaTagTitle() {
		return metaTagTitle;
	}

	public void setMetaTagTitle(String metaTagTitle) {
		this.metaTagTitle = metaTagTitle;
	}

	public String getMetaTagDescription() {
		return metaTagDescription;
	}

	public void setMetaTagDescription(String metaTagDescription) {
		this.metaTagDescription = metaTagDescription;
	}

}
