package com.taotao.common.pojo;
/**
 * 
 * @ClassName:  QbcItem   
 * @Description:TODO(商品信息模糊查询使用)   
 * @author: AJie
 * @date:   2018年11月10日 下午6:28:45   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class QbcItem {

	private String title;

    private String sellPoint;

    private String price;

	private int page;
    
    private int rows;
    
    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
