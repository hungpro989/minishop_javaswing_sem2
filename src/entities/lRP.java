/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Hung Dep Trai
 */
public class lRP {
    private int id;
    private String giatri;

    public lRP() {
    }

    public lRP(int id, String giatri) {
        this.id = id;
        this.giatri = giatri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
    }
    
}
