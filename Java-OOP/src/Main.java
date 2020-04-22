public class Main {
    public static void main(String[] args) {


        Manusia manusia = new Manusia("Riki Martua");
        Mahasiswa mahasiswa = new Mahasiswa("Riki", "123180030", 4.0);
        mahasiswa.noktp = "12738168240";
        /*manusia.umur=20;*/


        System.out.println("Nama :"+manusia.nama);
        System.out.println("Nim  :"+mahasiswa.getNim());
        System.out.println("No KTP :"+mahasiswa.noktp);
        System.out.println("IPK : "+mahasiswa.getIPK());
        System.out.println("USia : "+manusia.getUmur());

        mahasiswa.belajar();
        mahasiswa.berjoget("Tiktok");
        mahasiswa.belajar();
        mahasiswa.doTugas();

    }
}
