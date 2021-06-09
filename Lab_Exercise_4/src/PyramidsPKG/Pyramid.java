
package PyramidsPKG;

public class Pyramid {
    private String Pharaoh	       ;
    private String Ancient_name	       ;
    private String Modern_name	       ;
    private int Dynasty	               ;
    private String Site	               ;
    private double Base1_m	       ;
    private double Base2_m	       ;
    private double Height_m	       ;
    private double Slope_dec_degr      ;
    private double Volume_cu_m	       ;
    private double Latitude            ;
    private double Longitude	       ;
    private String Type                ;
    private String Lepsius	       ;
    private String Material	       ;
    private String Comment	       ;

    public Pyramid(String Pharaoh, String Ancient_name, String Modern_name, int Dynasty, String Site, double Base1_m, double Base2_m, double Height_m, double Slope_dec_degr, double Volume_cu_m, double Latitude, double Longitude, String Type, String Lepsius, String Material, String Comment) {
        this.Pharaoh = Pharaoh;
        this.Ancient_name = Ancient_name;
        this.Modern_name = Modern_name;
        this.Dynasty = Dynasty;
        this.Site = Site;
        this.Base1_m = Base1_m;
        this.Base2_m = Base2_m;
        this.Height_m = Height_m;
        this.Slope_dec_degr = Slope_dec_degr;
        this.Volume_cu_m = Volume_cu_m;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Type = Type;
        this.Lepsius = Lepsius;
        this.Material = Material;
        this.Comment = Comment;
    }

    public String getPharaoh() {
        return Pharaoh;
    }

    public String getAncient_name() {
        return Ancient_name;
    }

    public String getModern_name() {
        return Modern_name;
    }

    public int getDynasty() {
        return Dynasty;
    }

    public String getSite() {
        return Site;
    }

    public double getBase1_m() {
        return Base1_m;
    }

    public double getBase2_m() {
        return Base2_m;
    }

    public double getHeight_m() {
        return Height_m;
    }

    public double getSlope_dec_degr() {
        return Slope_dec_degr;
    }

    public double getVolume_cu_m() {
        return Volume_cu_m;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public String getType() {
        return Type;
    }

    public String getLepsius() {
        return Lepsius;
    }

    public String getMaterial() {
        return Material;
    }

    public String getComment() {
        return Comment;
    }
    
    
    

    @Override
    public String toString() {
        return "Pyramids{" + "Pharaoh=" + Pharaoh + ", Ancient_name=" + Ancient_name + ", Modern_name=" + Modern_name + ", Dynasty=" + Dynasty + ", Site=" + Site + ", Base1_m=" + Base1_m + ", Base2_m=" + Base2_m + ", Height_m=" + Height_m + ", Slope_dec_degr=" + Slope_dec_degr + ", Volume_cu_m=" + Volume_cu_m + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Type=" + Type + ", Lepsius=" + Lepsius + ", Material=" + Material + ", Comment=" + Comment + '}';
    }
   
    
}
