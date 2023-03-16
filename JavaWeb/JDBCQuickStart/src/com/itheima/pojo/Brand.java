package com.itheima.pojo;

/**
 * 品牌
 * alt + 左键，整列编辑
 * 基本数据类型用warper class
 */
public class Brand {
    // id primamry key
    private Integer id;
    // company name
    private String companyName;
    // ordered amount
    private Integer order;
    // description
    private String description;
    // status
    private Integer status;

    private String brandName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", order=" + order +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
