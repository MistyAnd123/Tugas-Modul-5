
package modul_5;

public class userService {
  // deklarasi variabel
  private String[][] data = new String[2][3];
  private String[][] histories = new String[2][4];
  private String username, password, roles = "";
  private String usernamex, buku1 = "", buku2 = "", tanggal = "";

  // constructor userService yang akan dijalankan saat inisialisasi dengan parameter emails dan passwords
  public userService(String usernames, String passwords)
  {
    // menset variabel email dan password sesuai dengan isi parameter constructor
    username = usernames;
    password = passwords;
    // membuat data user yang bisa login
    String[][] data = 
    { 
        {"Lukman E", "xxyyzz", "superAdmin"},
        {"Nisrina S", "akucantik", "superAdmin"} 
    };
    // dibuat data histories berisi buku yang email user, buku yang dipinjam, dan tanggal peminjaman
    String[][] histories = 
    {
        {"Lukman", "Program C++", "Kimia", "03-05-2020"},
        {"Nisrina", "Kalkulus", "Olahraga", "07-05-2020"} 
    };
    this.data = data;
    this.histories = histories;
  }
  // function check credentials yang akan mengembalikan boolean dengan modifier private
  private boolean checkCredential()
  {
    // perulangan for dengan inisialisasi i = 0, jarak i kurang dari banyak data, dan increment i++
    // untuk mengecek setiap data yang ada pada constructor
    for(int i = 0; i < data.length; i++ )
    {
        // jika data sama dengan email yang diinput
        if(data[i][0].equals(username))
        {
            // jika password sama dengan password yang diinput
            if(data[i][1].equals(password))
            {
                // maka akan menset nilai buku1, buku2, dan tanggal sesuai dengan email user yang login
                // diambil dari array histories
                usernamex = histories[i][0];
                buku1 = histories[i][1];
                buku2 = histories[i][2];
                tanggal = histories[i][3];
                // dan akan menset variabel roles dengan isi data role yang sesuai
                roles = data[i][2];
                // dan mengembalikan boolean true
                return true;
            }
        }
    }
    // jika gagal maka akan mengembalikan boolean false
    return false;
  }
  // function login dengan modifier public
  public void login()
  {
    // variabel status bertipe boolean yang memanggil function checkCredential
    boolean status = checkCredential();
    // jika status bernilai true
    if(status == true)
    {
        // maka akan menampilkan welcome role, dan email user yang login
        System.out.println("\nSelamat Datang " + roles);
        System.out.println("Logged it as " + username);
        // lalu akan menampilkan buku yang dipinjam dan tanggal peminjaman
        System.out.println(usernamex +" belum mengemalikan buku : ");
        System.out.println("Buku 1 : " + buku1);
        System.out.println("Buku 2 : " + buku2);
        System.out.println("Waktu batas Pengembalian : " + tanggal);
        System.out.println("Harap segera mengembalikan bukunya yaa");
    }
    else
    {
        // jika bernilai false maka akan menampilkan invalid login
        System.out.println("\nInvalid Login Silahkan coba lagi slurr");
    }
  }
}
