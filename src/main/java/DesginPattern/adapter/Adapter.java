package DesginPattern.adapter;

public class Adapter {

    public static void main(String[] args) {
        Marker marker = new PemanentMarker();
        Pen pen = new MarkerAdapter(marker);
        pen.write();
    }

}
