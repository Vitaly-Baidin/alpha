package com.viskei.alpha.model;

public class Gif {

    private GifData data;

    public Gif() {
    }

    public Gif(GifData gifData) {
        this.data = gifData;
    }

    public GifData getData() {
        return data;
    }

    public void setData(GifData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Gif{" +
                "data=" + data +
                '}';
    }
}
