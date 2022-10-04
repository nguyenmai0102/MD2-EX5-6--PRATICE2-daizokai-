package ra.run;


import ra.dev.Product;
import ra.catalog.Catalog;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ProductManagement {
// khai báo biến toàn cục mảng, sản phẩm, chỉ số biến cao nhất của sp;

    static Product[] arrProducts = new Product[1000];
    static Catalog[] listCatalog = new Catalog[100];


// biến khởi tạo sp;

    static int index = 0;
    static int indexCatalog = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            System.out.println("0. QUẢN LÝ CỬA HÀNG");
            System.out.println("1. Quản Lý Danh Mục");
            System.out.println("2. Quản Lý Sản Phẩm");
            System.out.println("3. thoát (thoát khỏi ứng dụng)");
            System.out.print("4. sự lựa chọn của bạn\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManagement.showListCatalog235();
                    break;

                case 2:
                    ProductManagement.showListProduct2();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("vui lòng chọn 1 hoặc 2");
            }

        } while (true);

    }

    //  -----------------------QUẢN LÝ DANH MỤC---------------------------------------
    // -----------nhập thông tin n danh mục--------------

    public static void showListCatalog235() {
        boolean checkout = true;
        do {
            System.out.println("*************QUẢN LÝ DANH MỤC*************");
            System.out.println("1: nhập thông tin n danh mục ");
            System.out.println("2. hiển thị thông tin danh mục theo mức độ ưu tiên");
            System.out.println("3. cập nhập thông tin danh mục theo mã danh mục và chỉnh sửa");
            System.out.println("4. thoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManagement.inputCatalogList(scanner);
                    break;
                case 2:
                    ProductManagement.showListCatalog();
                    break;
                    case  3:
                    ProductManagement.editListCatalog();
                        break;
                case 4:
                    checkout = false;
                    break;
                default:
                    System.out.println(" lua chon tu 1 den 3");

            }
        } while (checkout);


    }

    public static void showListProduct2() {
        boolean checkout = true;
        do {
            System.out.println("*************QUẢN LÝ SẢN PHẨM*************");
            System.out.println("1. nhập thông tin cho n sản phẩm");
            System.out.println("2. tính giá bán cho tất cả sản phẩm");
            System.out.println("3. hiển thị thông tin các sản phẩm");
            System.out.println("4. sắp xêếp sản phẩm theo giá bán tăng dần");
            System.out.println("5. tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. thống kê số lượng và in thông tin sản phẩm sắp hết hàng");
            System.out.println("7. cặp nhập trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("8: nhập hàng");
            System.out.println("9:xuất hàng");
            System.out.println("10. thoát");
            System.out.print("lựa chọn của bạn\n");
            int choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    ProductManagement.inputListProduct(scanner);
                    break;
                case 2:
                    ProductManagement.calExportPriceListProduct();

                    break;
                case 3:
                    ProductManagement.displayListProduct();
                    break;
                case 4:
                    ProductManagement.sortListProductByExportPriceABC();
                    break;
                case 5:
                    ProductManagement.searchProductByName(scanner);
                    break;
                case 6:
                    ProductManagement.countProduct();
                    break;
                case 7:
                    ProductManagement.updateStatusProduct(scanner);
                    break;
                case 8:
                    ProductManagement.enterProduct(scanner);
                    break;
                case 9:
                    ProductManagement.outProduct();
                    break;
                case 10:
                    // cho trở về manu chính
                    checkout = false;
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 đến 8");
            }

        } while (checkout);

    }
//***************** quản lý danh mục ***********************************
    public static void inputCatalogList(Scanner sc) {
        System.out.println("nhập vào số lượng danh mục cần nhập thông tin");
        int danhMuc = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < danhMuc; i++) {
            System.out.println(" nhập thông tin vao danh mục số " + (i + 1) + ":\n");
            listCatalog[indexCatalog] = new Catalog();
            listCatalog[indexCatalog].inputData();
            indexCatalog++;
        }
        System.out.printf("%-15s%-30s%-20s%-15s\n", "catalogId","catalogName", "priority", "catalogStatus");
        for (int i = 0; i < danhMuc; i++) {
            listCatalog[i].displayData();
        }
    }

    //----------------xắp xếp theo mức độ ưu tiên------------------------------------
    public static void showListCatalog() {
        System.out.println("hiện tại có " +null + indexCatalog + null+ " danh mục");
        Catalog temp;
        for (int i = 0; i < indexCatalog - 1; i++) {
            for (int j = i + 1; j < indexCatalog; j++) {
                if (listCatalog[i].getPriority() > listCatalog[j].getPriority()) {
                    temp = listCatalog[i];
                    listCatalog[i] = listCatalog[j];
                    listCatalog[j] = temp;

                }

            }
            System.out.println("đã xắp xếp xong theo mức độ ưu tiên");

        }
        // hien thi danh muc
        System.out.printf("%-15s%-30s%-20s%-15s\n", "catalogId","catalogName", "priority", "catalogStatus");
        for (int i = 0; i < indexCatalog; i++) {
            listCatalog[i].displayData();
        }
    }

    // ---------------------chinh sua danh muc-----------------
    public static void editListCatalog() {
        System.out.println("nhap ma id cua sp muon chinh sua");
        int maxId = Integer.parseInt(scanner.nextLine());
        //tim trong danh sCH DANH muc can cap nhap

        for (int i = 0; i < indexCatalog; i++) {
            if (maxId == listCatalog[i].getCatalogId()) {
                System.out.println("nhap ten moi");
                listCatalog[i].setCatalogName(scanner.nextLine());
                System.out.println("nhap trang thai moi");
                listCatalog[i].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                System.out.println("nhap muc do uu tien");
                listCatalog[i].setPriority(Integer.parseInt(scanner.nextLine()));
            }
        }
        System.out.printf("%-15s%-30s%-20s%-15s\n", "catalogId","catalogName", "priority", "catalogStatus");
        for (int i = 0; i < indexCatalog; i++) {
            listCatalog[i].displayData();
        }
    }

    // ************************ quản lý sản phẩm**************
    // Nhập thông tin cho n sản phẩm
    public static void inputListProduct(Scanner sc) {
        System.out.println("nhập vào số lượng sp cần nhập thông tin");
        int sp = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < sp; i++) {
            System.out.println("nhập thông tin cho sp thứ  " + (i + 1) + ":\n");
            arrProducts[index] = new Product();
            arrProducts[index].inputData(sc, listCatalog, indexCatalog);
            index++;
        }
    }

    // tinh gia cho tung sp;
    public static void calExportPriceListProduct() {
        for (int i = 0; i < index; i++) {
            arrProducts[i].calExportPrice();

        }
        System.out.println(" da tinh xong gia ban cuar sp");
    }

    // in ra toan bo danh muc sp
    public static void displayListProduct() {
        System.out.printf("%-15s%-30s%-15s%-30s%-30s%-10s%-20s%-15s%-20s\n", "product Id", "product Name",
                "title", "import Price", "export Price", "quantity", " descriptions", "productStatus", "catalog");
        for (int i = 0; i < index; i++) {
            arrProducts[i].displayData();
        }
    }

    // sawp xep sp theo gia ban tawng daan
    public static void sortListProductByExportPriceABC() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                if (arrProducts[i].getExportPrice() > arrProducts[j].getExportPrice()) {
                    Product temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }

        }
        System.out.println(" da xep xong cac sp theo gia ban tang dan");
    }

    // tim sp theo ten
    public static void searchProductByName(Scanner scanner) {
        System.out.println("nhap vao ten sp can tim: ");
        String strSearch = scanner.nextLine();
        System.out.printf("%-15s%-30s%-15s%-30s%-30s%-10s%-20s%-15s%-20s\n", "product Id", "product Name",
                "title", "import Price", "export Price", "quantity", " descriptions", "productStatus", "catalog");
        for (int i = 0; i < index; i++) {
            if (arrProducts[i].getProductName().startsWith(strSearch)) {
                arrProducts[i].displayData();
            }
        }

    }

    // thong ke so luong va in thong tin san pham sap het hang;
    public static void countProduct() {
        int count = 0;
        System.out.printf("%-15s%-30s%-15s%-30s%-30s%-10s%-20s%-15s%-20s\n", "product Id", "product Name",
                "title", "import Price", "export Price", "quantity", " descriptions", "productStatus", "catalog");
        for (int i = 0; i < index; i++) {
            if (arrProducts[i].getQuantity() <= 5) {
                count++;
                arrProducts[i].displayData();
            }
        }
        System.out.printf(" có $d sp sắp hết hàng \n", count);
    }
// cap nhap trang thai của sp
    public static void updateStatusProduct(Scanner sc) {
        String strUpdate = " ";
        System.out.println("  nhập mã của sp muốn thay đổi: ");
        strUpdate = sc.nextLine();
        for (int i = 0; i < index; i++) {
            if (arrProducts[i].getProductId().equals(strUpdate)) {
                arrProducts[i].setProductStatus(!arrProducts[i].isProductStatus());
            }

        }
        System.out.println("đã cập nhâp thành công trạng thái của sản phẩm");
    }
    //nhap hang
    public static void enterProduct(Scanner sc){
        System.out.printf("%-15s%-30s%-15s%-30s%-30s%-10s%-20s%-15s%-20s\n", "product Id", "product Name",
                "title", "import Price", "export Price", "quantity", " descriptions", "productStatus", "catalog");
        for (int i = 0; i < index; i++) {
          arrProducts[i].displayData();
        }
        System.out.println("nhập mặt hàng muốn nhập");
       String put = sc.nextLine();
        for (int i = 0; i < index; i++) {
            if (arrProducts[i].getProductName().equals(put)){
                System.out.println("số lượng cần nhập");
                int slNhap = Integer.parseInt(sc.nextLine());
                arrProducts[i].setQuantity(arrProducts[i].getQuantity()+slNhap);

            }

        }
        System.out.println("đã nhập  thành công");
    }
// xuat hang
    public static void outProduct(){
        System.out.printf("%-15s%-30s%-15s%-30s%-30s%-10s%-20s%-15s%-20s\n", "product Id", "product Name",
                "title", "import Price", "export Price", "quantity", " descriptions", "productStatus", "catalog");
        for (int i = 0; i < index; i++) {
            arrProducts[i].displayData();
        }
        System.out.println("nhập mặt hàng cần xuất");
        String out = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (arrProducts[i].getProductName().equals(out));
            System.out.println(" nhập số lượng cần xuất");
            int slXuat = Integer.parseInt(scanner.nextLine());
            arrProducts[i].setQuantity(arrProducts[i].getQuantity()-slXuat);

        }
    }
}

