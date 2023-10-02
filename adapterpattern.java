import java.util.*;
 
interface Chargeable {

 public void charge();

}
 class Xiomi implements Chargeable {

 @Override
 public void charge() {

  System.out.println("Charging Mi phone .....");

 }

}
class NokiaLumia implements Chargeable {

 @Override
 public void charge() {

  System.out.println("Charging Nokia Lumia ..... ");

 }

}
 class SamsungS3 {

 public void samsungCharge() {
  System.out.println("Charging Samsung S3 ....... ");
 }

}

 class SamsungAdapterPlug implements Chargeable {

 SamsungS3 samsungS3;

 public SamsungAdapterPlug(SamsungS3 samsungS3) {
  this.samsungS3 = samsungS3;
 }

 // Calling the same charge method
 // but internally its making a call 
 // to samsung charge method. Thus 
 // adapting it to use Nokia charger.
 @Override
 public void charge() {

  samsungS3.samsungCharge();

 }


 public String toString() {
  return "Samsung Mobile pretending to be Nokia Mobile ......";
 }

}

 class Main {

 public static void main(String[] args) {

  System.out.println("Let's Charge our mobiles.... ");

  // Creating Objects
  Xiomi Xiomi = new Xiomi();
  NokiaLumia nokiaLumia = new NokiaLumia();
  SamsungS3 samsungS3 = new SamsungS3();

 
  SamsungAdapterPlug samsungAdapterPlug = new SamsungAdapterPlug(samsungS3);

  
  Xiomi.charge();
  nokiaLumia.charge();

  // Calling Samsung Adapter Plug charge
  // method , which will internally call
  // SamsungS3 charge method.
  samsungAdapterPlug.charge();

 }

}
