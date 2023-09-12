package DesginPattern.adapter;

public class PemanentMarker implements Marker{

    @Override
    public void mark() {
        System.out.println("write by marker");
    }
}
