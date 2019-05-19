package com.land.rest.pojo;

/**
 * 
 * @ClassName:  SelectCoParm   
 * @Description:TODO(公司查询参数类)
 * @author: AJie
 * @date:   2019年5月16日 上午11:56:02
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class SelectCoParm {

	private String corporationNature;

	private String name;
	
	private int comm;
	
	public String getCorporationNature() {
		return corporationNature;
	}

	public void setCorporationNature(String corporationNature) {
		this.corporationNature = corporationNature;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

}
