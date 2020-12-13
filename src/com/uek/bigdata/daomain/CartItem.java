package com.uek.bigdata.daomain;

/**
 * @author 优逸客大数据研发部
 * @className: CartItem
 * @description: 购物车JavaBean实体类
 * @date: 2020/11/26 12:38
 * @version: 1.0
 */
public class CartItem {

    private Integer id;         //主键
    private String userId;

    public CartItem(Integer id, String userId, String name, Integer count, double price, double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String name;        //商品名称
    private Integer count;      //购买数量
    private double price;       //商品价格
    private double totalPrice;  //消费金额

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, double price) {
        this(name , count , price);
        this.id = id;
    }

    public CartItem(String name, Integer count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = count * price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}