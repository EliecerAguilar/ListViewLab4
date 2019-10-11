package com.example.jotaz.listviewexample;

public class Chat {
    private String user;
    private String msj;
    private String h;
    private int img;

    public Chat(String usuario, String mensaje, String hora, int imagen) {
        this.user = usuario;
        this.msj = mensaje;
        this.h = hora;
        this.img = imagen;
    }


    public String getUser() {
        return user;
    }

    public String getMsj() {
        return msj;
    }

    public String getH() {
        return h;
    }

    public int getImg() {
        return img;
    }
}
