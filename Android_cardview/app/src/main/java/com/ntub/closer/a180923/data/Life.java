package com.ntub.closer.a180923.data;

public class Life {
    private int picture;  //圖片id
    private String info;  //文字

    public Life(int picture, String info){
        this.picture=picture;
        this.info=info;
    }

    public int getPicture(){return this.picture;}
    public String getInfo(){return this.info;}
}
