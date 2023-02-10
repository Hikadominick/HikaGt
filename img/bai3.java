package Lab5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class SanPham{
    String tenSP;
    Double gia;
}
public class bai3 {
    public static void menu() {
        System.out.println("+--------------------Menu-------------------+");
        System.out.println("| 1. Nhap danh sach san pham                |");
        System.out.println("| 2. Sap xep giam dan theo gia va xuat kq   |");
        System.out.println("| 3. Tim va xoa san pham theo ten           |");
        System.out.println("| 4. Xuat gia trung binh cua cac san pham   |");
        System.out.println("| 5. Ket thuc                               |");
        System.out.println("+-------------------------------------------+");
        System.out.println("chon chuc nang: ");
        
    }
    public static void timXoa(ArrayList<SanPham> ds) {
        var in=new Scanner(System.in);
        boolean timthay = false;
        System.out.print("Nhap ten san pham can xoa: ");
        String ten = in.nextLine();
        for(int i=0;i<ds.size();i++){
            if(ds.get(i).tenSP.equalsIgnoreCase(ten)){
                ds.remove(i);
                System.out.println("Da xoa");
                System.out.println("Danh sach con lai");
                xuat(ds);
                timthay=true;
            }
        }
        if(!timthay)
            System.out.println("Khong tim thay!");
    }
    public static void nhap(ArrayList<SanPham> ds) {
        String choice="";
        do{
            SanPham sp=new SanPham();
            Scanner in=new Scanner(System.in);
            System.out.print("Nhap ten san pham: ");
            sp.tenSP=in.nextLine();
            System.out.print("Nhap gia: ");
            sp.gia=in.nextDouble();in.nextLine();
            System.out.print("Nhap tiep kg? (y/n)");
            choice=in.nextLine();
            ds.add(sp);
        }while(choice.equalsIgnoreCase("y"));
        
    }
    public static void xuat(ArrayList<SanPham> ds) {
        System.out.println("----- Danh sach san pham -----");
        int i=1;
        for(SanPham sp:ds){
            System.out.println(i+"\t"+sp.tenSP+"\t"+sp.gia);
            i++;
        }
    }
    public static void xuatGiaTB(ArrayList<SanPham> ds) {
        double sum=0.0;
        for(SanPham sp:ds){
            sum += sp.gia;
        }
        System.out.println("Gia trung binh:"+(sum/ds.size()));
    }
    public static void main(String[] args) {
        ArrayList<SanPham> ds=new ArrayList<SanPham>();
        Comparator<SanPham> comp= new Comparator<SanPham>(){
        
            @Override
            public int compare(SanPham o1, SanPham o2) {
                return o1.gia.compareTo(o2.gia);
            }  
        };
        Scanner in=new Scanner(System.in);
        int chon;
        do{
           menu();
           chon =in.nextInt();
           switch(chon){
               case 1: nhap(ds);
               break;
               case 2: Collections.sort(ds, comp);
               Collections.reverse(ds);
               xuat(ds);
               break;
               case 3: timXoa(ds);
               break;
               case 4: xuatGiaTB(ds);
               break;
               default:
                   if(chon==5){
                       System.out.println("Hen gap lai !!!");
                       break;
           }else{
                       System.out.println("Bạn chỉ được nhập từ 1-5 mời bạn nhập lại");
                       break;
                   }
           }
        }while(chon !=5);
    }
}