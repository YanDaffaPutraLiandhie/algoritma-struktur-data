import java.util.ArrayList;

class Mobil {
    private String merk;
    private int hargaBeli;
    private int cc;
    private int tahunProduksi;

    public Mobil(String merk, int hargaBeli, int cc, int tahunProduksi) {
        this.merk = merk;
        this.hargaBeli = hargaBeli;
        this.cc = cc;
        this.tahunProduksi = tahunProduksi;
    }

    public double Pajak() {
        if (cc > 1500) {
            return hargaBeli * 0.10;
        } else {
            return hargaBeli * 0.075;
        }
    }

    public double BiayaPerawatan() {
        if (tahunProduksi < 2010) {
            return hargaBeli * 0.08;
        } else {
            return hargaBeli * 0.05;
        }
    }

    public double BiayaTotal() {
        return Pajak() + BiayaPerawatan();
    }

    public int TahunProduksi() {
        return tahunProduksi;
    }

    public int CC() {
        return cc;
    }

    public String toString() {
        return "Merk: " + merk + ", Harga Beli: " + hargaBeli + ", CC: " + cc + ", Tahun Produksi: " + tahunProduksi;
    }
}

public class MobilMain {
    public static void main(String[] args) {
        ArrayList<Mobil> mobilList = new ArrayList<>();
        mobilList.add(new Mobil("dodge chalenger", 20000, 2100, 2005));
        mobilList.add(new Mobil("toyota supra", 35000, 1200, 2015));
        mobilList.add(new Mobil("honda civic", 18000, 2000, 2006));

        double totalBP = 0;
        int count = 0;
        for (Mobil mobil : mobilList) {
            if (mobil.TahunProduksi() > 2010) {
                totalBP+= mobil.BiayaPerawatan();
                count++;
            }
        }
        double rata2BiayaPer = totalBP/ count;
        System.out.println("Biaya perawatan rata-rata mobil dengan tahun produksi > 2010: " + rata2BiayaPer);

        double maxBiayaTotal = 0;
        Mobil mobilTerbesar = null;
        for (Mobil mobil : mobilList) {
            if (mobil.CC() > 1500 && mobil.TahunProduksi() < 2010) {
                double biayaTotal = mobil.BiayaTotal();
                if (biayaTotal > maxBiayaTotal) {
                    maxBiayaTotal = biayaTotal;
                    mobilTerbesar = mobil;
                }
            }
        }
        System.out.printf("Mobil dengan biaya total terbesar:" + "%n" + mobilTerbesar + "%n" + "dengan biaya total sebesar " + maxBiayaTotal );
      
    }
}