/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customObject;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
 *
 * @author dex
 */
public class getTodayDate {
    private Date today;
    private SimpleDateFormat date;
    private SimpleDateFormat time;
    
    public getTodayDate() {
        this.today = new Date();
        this.date = new SimpleDateFormat("dd-MM-yyyy");
        this.time = new SimpleDateFormat("HH:mm:ss");
    }
    public String getDate(){
        return "Date: " + this.date.format(this.today) + ", Time: " + this.time.format(today);
    }
}
