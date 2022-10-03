package ra.catalog;

import java.util.Scanner;

public class Catalog {
    private int catalogId;

    private String catalogName;

    private int priority;

    private  boolean catalogStatus;

// cac constructor;
    public Catalog(){

    }
    public Catalog(int Id, String name, int priority, boolean catalogStatus){
// khoi tao thuoc tinh cho doi tuong;
        this.catalogId = Id;
        this.catalogName= name;
        this.priority = priority;
        this.catalogStatus=catalogStatus;

    }
    // cac thuoc tinh
    //1. getter va setter


    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
// 3. cac phuowng thuc xuat nhap

    public void inputData(){
        Scanner sc   = new Scanner(System.in);

        System.out.println("nhập vào mã danh mục sản phẩm");
        this.catalogId =Integer.parseInt (sc.nextLine());
        System.out.println("nhập vào tên danh mục sản phẩm");
        this.catalogName = sc.nextLine();
        System.out.println("nhập vào mức độ ưu tiên");
        this.priority=Integer.parseInt(sc.nextLine());
        System.out.println("nhập vào trạng thái danh mục");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());


    }
    public void displayData(){
        System.out.printf("%-15d%-30s%-20d%-15s\n", this.catalogId,this.catalogName, this.priority, this.catalogStatus);
    }
}
