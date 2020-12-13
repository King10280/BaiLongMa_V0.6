package com.uek.bigdata.daomain;

/**
 * @author 优逸客大数据研发部
 * @className: Goods
 * @description: 商品JavaBean实体类
 * @date: 2020/11/26 12:38
 * @version: 1.0
 */
public class Goods implements Comparable<Goods> {

    private int id;                 //商品id
    private String name;            //商品名称
    private double price;           //商品价格
    private int sales;              //商品销量
    private int stock;              //商品库存
    private String category;        //商品分类
    private String location;        //商品产地
    private String imagePath;       //图片路径

    /**
     * 排序策略：按照商品的销量，进行降序排序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Goods o) {
        if (this.sales - o.sales > 0) {
            return -1;
        } else if (this.sales - o.sales < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public Goods() {
    }

    public Goods(int id, String name, double price, int sales, int stock, String category, String location, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.category = category;
        this.location = location;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}