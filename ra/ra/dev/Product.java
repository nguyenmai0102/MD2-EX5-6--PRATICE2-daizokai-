package ra.dev;

import ra.catalog.Catalog;

import java.util.Calendar;
import java.util.Scanner;

public class Product {
    //1. nhap cac thuoc tinh;
    private String productId;

    private String productName;

    private String title;

    private float importPrice;

    private float exportPrice;

    private int quantity;

    private String descriptions;

    private boolean productStatus;

    private Catalog catalog;

    //2. cac constructor;
    public Product(){

    }

    public Product(String productId, String productName, String title, float importPrice, float exportPrice, int quantity, String descriptions, boolean productStatus, Catalog catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }
    //3. raBig.ra.run.ra.ca phuowng thuc getter/ setter

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
    //3. cac phuowng thuc khac

    public void inputData(Scanner sc, Catalog[] arrCatalog, int indexMax){
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhập vào mã sản phẩm");
        this.productId = scanner.nextLine();

        System.out.println("nhập vào tên sản phẩm");
        this.productName = scanner.nextLine();

        System.out.println("nhập vào tiêu đề sản phẩm");
        this.title = scanner.nextLine();

        System.out.println("nhập vào giá của sản phẩm");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("in ra số lượng còn lại của sản phẩm");
        this.quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("mô tả sản phẩm");
        this.descriptions = scanner.nextLine();

        System.out.println("trạng thái sản phẩm");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("in ra danh mục sản phẩm mà sản phẩm thuộc về");
        for (int i = 0; i < indexMax; i++) {
            System.out.printf("%d, %s\n", i+1, arrCatalog[i].getCatalogName());

        }
        System.out.println("lua chon cua ban");
        int indexChoice = Integer.parseInt(sc.nextLine());
        // set doi tuong danh muc cho sp;
        this.catalog= arrCatalog[indexChoice-1];

    }
   public void displayData(){
        System.out.printf("%-15s%-30s%-15s%-30f%-30f%-10d%-20s%-15b%-20s\n", this.productId, this.productName,
                this.title, this.importPrice, this.exportPrice, this.quantity, this.descriptions, this.productStatus, this.catalog);

   }
   public void calExportPrice(){
this.exportPrice = this.importPrice*1.2F;
   }

}
