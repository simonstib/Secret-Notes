/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretnotes.model;

/**
 *
 * @author MSimons
 */
public class Model {

    private int x;
    private String key;

    public Model() {
        x = 0;
       
    }

    public Model(int x) {
        this.x = x;
    }

    public void incX() {
        x++;
    }

    public int getX() {
        return x;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    
}
