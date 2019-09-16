package com.jsite.modules.gok.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.jsite.common.persistence.TreeEntity;

/**
 * 网站集锦Entity
 * @author 网站集锦
 * @version 2019-03-29
 */
public class GokWebsites extends TreeEntity<GokWebsites> {
	
	private static final long serialVersionUID = 1L;

	private String icon;		// 图标
	private String title;		// 标题
	private String indes;		// 锚点
	private String mark;		// 备注
	private String url;		// 地址
	private String image;		// 图片
	
	public GokWebsites() {
		super();
	}

	public GokWebsites(String id){
		super(id);
	}


	@Override
	public GokWebsites getParent() {
		return parent;
	}

    @Override
	public void setParent(GokWebsites parent) {
		this.parent = parent;
	}
	@Length(min=0, max=64, message="图标长度必须介于 0 和 64 之间")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Length(min=0, max=64, message="标题长度必须介于 0 和 64 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=64, message="锚点长度必须介于 0 和 64 之间")
	public String getIndes() {
		return indes;
	}

	public void setIndes(String indes) {
		this.indes = indes;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Length(min=0, max=255, message="地址长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=255, message="图片长度必须介于 0 和 255 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}