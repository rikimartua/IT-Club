public class Manusia {
    String nama;
    String noktp;
    int umur;

    public Manusia(String nama){
        this.nama = nama;

    }


    public void makan(){
        System.out.println("sedang makan");
    }

  /*  =====================Overloading===========================*/
    public void makan(String nama){
        System.out.println(nama + " sedang makan");
    }
    public void makan(String nama, int umur){

        System.out.println(nama + " sedang makan dengan umur " + umur);
    }


    public void tidur(String nama){
        System.out.println(nama + " sedang tidur");
    }

    public int getUmur() {
        return umur=20;
    }


}
