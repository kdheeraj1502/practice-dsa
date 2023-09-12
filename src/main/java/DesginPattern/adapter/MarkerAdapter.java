package DesginPattern.adapter;

public class MarkerAdapter implements Pen{

    Marker marker;

    MarkerAdapter(Marker marker){
        this.marker = marker;
    }
    @Override
    public void write() {
        marker.mark();
    }
}
